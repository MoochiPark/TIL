CREATE TABLE DRAMA (
  DRM_CODE VARCHAR(20) PRIMARY KEY,
  DRM_NAME VARCHAR(20) NOT NULL,
  DRM_PRD VARCHAR(20) NOT NULL,
  DRM_BRD VARCHAR(20) NOT NULL,
  DRM_OPDATE TIMESTAMP
);

INSERT INTO DRAMA VALUES ('DRM01', '���� ����', 'TG', 'SBC', '2013.01.01'),
  ('DRM02', '���̷���', 'SN', 'KBC', '2013.01.01'),
  ('DRM03', '��ŷ', 'TG', 'SBC', '2013.02.01'),
  ('DRM04', '���� ȣ', 'HNU-E', 'MBS', '2013.02.01'),
  ('DRM05', '5�� �繫��', 'SN', 'MBS', '2013.02.15'),
  ('DRM06', '�� ���', 'XTS', 'XTS', '2013.02.15'),
  ('DRM07', '������ ��', 'HNU-E', 'KBC', '2013.03.15'),
  ('DRM08', '�Ӵ��� ȭ��', 'TG', 'SBC', '2013.03.15');
INSERT INTO DRAMA (DRM_CODE, DRM_NAME, DRM_PRD, DRM_BRD) VALUES
  ('DRM09', 'ȸ���� ��', 'SN', 'KBC'),
  ('DRM10', '���ǻ�', 'HNU-E', 'XTS');