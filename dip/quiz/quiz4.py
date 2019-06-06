import numpy as np
import cv2
from   matplotlib import pyplot as plt

img = cv2.imread('../data/aram.jpg')
img_hsv = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)

# HSV 에서 BGR 로 가정할 범위를 정의함
lower_blue = np.array([0, 60, 80])
upper_blue = np.array([80, 255, 255])

# HSV 이미지에서 청색만, 또는 초록색만 또는 빨간색만 추출하기 위한 임계값
# lower_blue, upper_blue 로 지정한 범위에 있는지 체크한 후,
# 범위에 해당하는 부분은 그 값 그대로, 나머지 부분은 0으로 채워서 반환
mask_blue = cv2.inRange(img_hsv, lower_blue, upper_blue)

# mask 와 원본 이미지를 비트 연산함
res1 = cv2.bitwise_and(img, img, mask=mask_blue)
res1 = cv2.cvtColor(res1,cv2.COLOR_BGR2RGB)
cv2.imshow('img', img)
# cv2.imshow('BLUE', res1)
plt.imshow(res1)

plt.show()
cv2.waitKey(0)
cv2.destroyAllWindows()
# import cv2
#
# src = cv2.imread('../data/pompeio.jpg')
# cv2.imshow('src',  src)
# height, width = src.shape[:2]
# print('width= ', width, 'height= ', height) #확인용 프린트
# #1
# hsv    = cv2.cvtColor(src, cv2.COLOR_BGR2HSV)
# h, s, v = cv2.split(hsv)
# for i in range(height):
#     for j in range(width):
#         if not(h[i,j] > 7 and h[i,j] < 20 and s[i,j] > 255 * 0.18 and s[i,j] < 255 * 0.6):
#             v[i,j] = 0
# hsv2 = cv2.merge([h, s, v])
# dst = cv2.cvtColor(hsv2, cv2.COLOR_HSV2BGR)
# cv2.imshow('dst',  dst)
#
# cv2.waitKey()
# cv2.destroyAllWindows()