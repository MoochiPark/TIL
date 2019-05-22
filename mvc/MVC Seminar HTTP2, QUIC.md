# MVC Seminar HTTP/2, QUIC.



# 1. HTTP/2



## 1.1 HTTP/1.1의 동작방식

 HTTP/1.1 프로토콜은ㅇ 클라이언트와 서버간 통신을 위해 ㅐ다음과 같은 과정을 거치게 된다. 

![http1_connection](http://www.popit.kr/wp-content/uploads/2016/11/http1-1e8d6f2a-403x600.png)

**HTTP/1.1은 기본적으로 Connection당 하나의 요청을 처리 하도록 설계**되어있다.

그래서 위 그림과 같이 동시전송이 불가능하고 요청과 응답이 순차적으로 이루어 지게된다.

그렇다보니 HTTP문서 안에 포함된 다수의 리소스(Image, CSS, Script 등)를 처리하려면 요청할 리소스 개수에 비례하여 Latency(대기 시간)는 길어지게 된다.



## 1.2 HTTP/1.1의 단점



### 1.2.1 Head Of Line Blocking (HOLB)

------

HTTP/1.1의 Connection당 하나의 요청처리를 개선할 수 있는 기법중 Pipelining이 존재하는데 이것은 하나의 Connection을 통해서 다수의 파일을 요청/응답 받을 수 있는 기법을 말한다.

이 기법을 통해서 어느정도의 성능 향상을 기대할 수 있으나 큰 문제점이 하나 있다.

하나의 연결에서 3개의 이미지 (a.png, b.png, c.png)를 얻으려고 하는 경우 HTTP의 요청순서는 다음 과 같다.

```
| --- a.png --- |
            | --- b.png --- |
                        | --- c.png --- |
```

순서대로 첫 번째 이미지를 요청하고 응답받고 다음 이미지를 요청하게 되는데 만약 첫 번째 이미지를 요청하고 응답이 지연되면 아래 그림과 같이 두, 세 번째 이미지는 당연히 첫 번째 이미지의 응답처리가 완료되기 전까지 대기하게 되며 이와 같은 현상을 **HTTP**의 **Head Of Line Blocking**이라 하며 Pipelining의 큰 문제점 중 하나이다.

```
| ------------------------------- a.png --------------- --- |
                                                       | -b.png- |
                                                               | --c.png-- |
```



### 1.2.2 RTT(Round Trip Time) 증가

--------

HTTP/1.1의 경우 일반적으로 하나의 Connection에 하나의 요청을 처리하다보니 매 요청별로 Connection을 만들게 되고 TCP상에서 동작하는 HTTP의 특성상 3-way Handshake가 반복적으로 일어나고 또한 불필요한 RTT 증가와 네트워크 지연을 초래하여 성능을 저하 시키게 된다.



### 1.2.3 무거운 Header 구조

-------

HTTP/1.1의 헤더에는 많은 메타정보들이 저장되어 있다. 사용자가 방문한 웹페이지는 다수의 HTTP요청이 발생하게 되는데 이 경우 **매 요청마다 중복된 헤더값을 전송**하게 되며 또한 해당 domain에 설정된 cookie정보도 매 요청마다 헤더에 포함되어 전송되며 어쩔땐 요청을 통해서 전송하려는 값보다 헤더값이 더 큰 경우도 있다.





## 1. 3 HTTP/2

SPDY는 웹 콘텐츠를 전송할 목적으로 구글이 개발한 비표준 개방형 네트워크 프로토콜이다. SPDY는 웹페이지 부하 레이턴시를 줄이고 웹 보안을 개선하는 목표 면에서 HTTP와 비슷하다. SPDY는 압축, 다중화, 우선 순위 설정을 통한 레이턴시 감소를 달성한다. HTTP/2는 이 SPDY를 기반으로 HTTP/2 작업그룹이 2012년 10월부터 시작한 새로운 프로토콜 구현 프로젝트이다.



## 1.4 HTTP/2의 성능 향상 요소



### 1.4.1 Multiplexed Streams

-------

한 커넥션으로 동시에 여러개의 메세지를 주고 받을 수 있으며, 응답은 순서에 상관없이 stream으로 주고 받는다. HTTP/1.1의 Connection Keep-Alive, Pipelining의 개선이라 보면 된다.

![img](https://kinsta.com/wp-content/themes/kinsta/images/learn/what-is-http2/http2_streams.png)



### 1.4.2 Stream Prioritization

-------

예를 들면 클라이언트가 요청한 HTML문서안에 CSS파일 1개와 Image파일 2개가 존재하고 이를 클라이언트가 각각 요청하고 난 후 Image파일보다 CSS파일의 수신이 늦어지는 경우 브라우저의 렌더링이 늦어지는 문제가 발생하는데, HTTP/2의 경우 리소스간 의존관계(우선순위)를 성정하여 이런 문제를 해결하고 있다.

![img](https://kinsta.com/wp-content/themes/kinsta/images/learn/what-is-http2/http2_weight.png)



### 1.4.3 Server Push

-------------

서버는 클라이언트의 요청에 대해 요청하지도 않은 리소스를 마음대로 보내줄 수도 있다.

클라이언트(브라우저)가 HTML 문서를 요청했고 해당 HTML에 여러 개의 리소스가 포함되어 있는경우 HTTP/1.1에서 클아이언트는 요청한 HTML문서를 수신한 후 HTML문서를 해석하면서 필요한 리소소를 재 요청하는 반면 HTTP/2에선 Server Push기법을 통해서 클라이언트가 요청하지도 않은 리소스를 Push해주는 방법으로 클라이언트의 요청을 최소화해서 성능 향상을 이끌어 낸다.

이를 **PUSH_PROMISE**라고 부르며 이를 통해서 서버가 전송한 리소스에 대해선 클라이언트는 요청을 하지 않는다.

![img](https://kinsta.com/wp-content/themes/kinsta/images/learn/what-is-http2/http2_push.png)



### 1.4.4 Header Compression

---------

HTTP/2는 Header 정보를 압축하기 위해 Header Table과 Huffman Encoding 기법을 사용하여 처리하는데 이를 HPACK 압축방식이라 부른다.



## 1.5 HTTP/1.1과 HTTP/2 성능비교

다음 이미지는 동일 개수/용량의 png 이미지를 웹사이트에 로딩시켜 HTTP/1.1과 HTTP/2의 속도를 비교한 결과이다.

![http/2](http://www.popit.kr/wp-content/uploads/2016/11/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA-2016-11-28-%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE-7.04.56-e1480949148639.png)

![http/2 ë¡ë© ìë](http://www.popit.kr/wp-content/uploads/2016/11/-2016-11-28-%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE-7.05.09-e1480949174419.png)

# 2. QUIC(Quick UDP Internet Connection)

우리가 사용하는 대부분의 애플리케이션과 웹서비스 등은 해외에 서버를 두고 있거나 클라우드를 통해 서비스를 제공하고 있다.

이러한 환경에서 기존 TCP를 이용한 서비스는 지연이 발생할 수 밖에 없는 구조를 가지고 있다.

> ### *TCP*
>
> - *TCP는 무결성을 전제로 만들어진 프로토콜.*
>
> - *데이터의 병목 지점이 없어도 데이터의 유실을 막기 위해 작은 단위로 쪼개서 전송하고,*
>
>   *전송이 성공했는지 계속해서 판단한다.*
>
> - *이러한 TCP의 특성상 물리적 거리가 멀어질수록 점점 RTT가 늘어나게 된다.*
>
> - *TCP 기반에서 연결을 수립할 때에는 3-Way Handshake 과정이 필요하며,* 
>
>   *여기에 암호화를 위해 TLS까지 적용된다면, 실제 통신이 이루어지기 이전에* 
>
>   *연결 수립만을 위한 지연이 약 4.5 RTT가 발생한다.*



## 2.1 QUIC의 특징

![img](https://lh3.googleusercontent.com/o62Ohn1Ppxna6zz0NtavqRyetjryOj-81Sz4bRt3U8lURVblk5RKOaCcf57i6BkmprremePJpq_sQcxfJiuA4wJBmRp3pR4BS1P-yiT6UNUPvnBeP_rLz9bvHxFE15kuNBM2hpE)

![img](https://blog.cloudflare.com/content/images/2018/07/http-request-over-quic@2x.png)

QUIC는 기본적으로 **Zero RTT**가 핵심이다. QUIC는 이론적으로 전송 왕복 시간이 0이다.

다른 프로토콜에 비해 가볍고, 성능과 보안성을 모두 고려해서 설계되었으며, 암호화된 전송을 통해 다중화된 스트림을 제공하는 UDP 기반 전송 프로토콜이다.

일반적인 TCP 연결에 비해서 대기시간이 훨씬 단축되고 스트림 다중화 지원이 향상된다.



> *실제 구글에서 QUIC를 적용한 이후 구글 검색에서 약 3%의 로딩 시간 개선,*
>
> *유튜브 시청 시 약 30% 정도 버퍼링 감소 했다고 함*



## 2.2 그 외의 장점

### **2.2.1 보안성 향상**

----------

**1) TLS 적용**

QUIC은 TLS 암호화를 기본적으로 적용하고 있다. 과거 SPDY와 마찬가지로 구글에서 설계한 네트워크 프로토콜은 기본적으로 암호화를 적용하고 있다. 서버의 포트도 디폴트가 443 UDP 포트를 사용하고 있다.



**2) IP Spoofing / Replay Attack 방지**

 QUIC에서는 필요에 따라 Source Address Token을 발급하여 출발지 아이피를 변조 및 재생공격에 대한 검증을 수행한다. 마치 TCP 통신에서 Sequence Number를 이용하여 신뢰관계를 맺은 클라이언트인지 검증하는 것과 같은 기능을 수행한다.



### **2.2.2 멀티플렉싱(multiplexing)**

-----------

멀티플렉싱 기법은 QUIC 프로토콜의 고유 특성은 아니다. 

위에서의 HTTP/2를 비롯한 다른 프로토콜에서도 단일 커넥션을 통해 하나의 통신 채널로 여러 데이터를 전송하는 기법들을 사용한다.

QUIC 에서는 좀 더 향상된 멀티플렉싱 기능을 제공한다.

TCP 통신에서는 다수의 개별 데이터를 하나의 통신채널로 전송중에 유실된 패킷이 발생하면 다른 데이터 역시 유실된 패킷이 재 전송 될 때까지 대기상태(Block)가 되지만, QUIC 에서는 유실된 패킷이 속한 데이터를 제외한 다른 데이터는 별도의 Block 없이 지속적으로 처리 할 수 있도록 설계되었다.

 

### **2.2.3 향상된 오류정정**

--------------

QUIC은 전방 오류정정 FEC(Forward Error Correction) 방식을 이용한다. 패킷이 전송 중 변조나 훼손이 발생했을 경우 재전송(Retransmission) 요청을 통해 다시 패킷을 송신하는 후방 오류정정(BEC)가 아닌 정정비트를 통해 훼손된 비트를 복구하도록 설계되었다.



QUIC 프로토콜은 그 외에도 성능 개선과 효율적인 전송을 위해 다양한 기능들을 가지고 있다.







### *Reference*

-----

[*나만 모르고 있던 HTTP/2 - 심천보*](https://www.popit.kr/나만-모르고-있던-http2/)

[*QUIC 프로토콜 - K씨*](https://blog.naver.com/PostView.nhn?blogId=renucs&logNo=220887163028)

[*QUIC (Quick UDP Internet Connection) 개념 - 팬도라*](<https://judo0179.tistory.com/41?category=214238>)

