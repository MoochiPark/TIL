# 1004.py

import cv2

import numpy as np

ap = 0
kernel = np.ones((1, 10), np.uint8)
kernel1 = np.ones((10, 1), np.uint8)
cap = cv2.VideoCapture('../data/vtest.avi')
if (not cap.isOpened()):
    print('Error opening video')
height, width = (int(cap.get(cv2.CAP_PROP_FRAME_HEIGHT)),
                 int(cap.get(cv2.CAP_PROP_FRAME_WIDTH)))

bgKnn2 = cv2.createBackgroundSubtractorKNN(dist2Threshold=1000,
                                           detectShadows=False)
AREA_TH = 80  # area   threshold


def findObjectAndDraw(bImage, src):
    res = src.copy()
    bImage = cv2.erode(bImage, None, 5)
    bImage = cv2.dilate(bImage, None, 5)
    bImage = cv2.erode(bImage, None, 7)
    contours, _ = cv2.findContours(bImage,
                                   cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)
    cv2.drawContours(src, contours, -1, (255, 0, 0), 1)
    for i, cnt in enumerate(contours):
        area = cv2.contourArea(cnt)
        if area > AREA_TH:
            x, y, width, height = cv2.boundingRect(cnt)
            cv2.rectangle(res, (x, y), (x + width, y + height), (0, 0, 255), 2)
    return res


# 3
t = 0
while True:
    ret, frame = cap.read()
    if not ret:
        break
    t += 1
    gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
    blur = cv2.GaussianBlur(frame, (5, 5), 0.0)
    bImage4 = bgKnn2.apply(blur)
    bImage4 = cv2.dilate(bImage4, kernel, iterations=2)
    bImage4 = cv2.erode(bImage4, kernel1, iterations=2)
    nlabels, labels, stats, centroids = cv2.connectedComponentsWithStats(bImage4)
    ap += nlabels
    for i in range(nlabels):
        area = stats[i, cv2.CC_STAT_AREA]
        if i == 1:
            conter_x = centroids[i, 0]
            conter_y = centroids[i, 1]
        elif i == 0:
            continue
        else:
            conter_x = int(centroids[i, 0])
            conter_y = int(centroids[i, 1])
        left = stats[i, cv2.CC_STAT_LEFT]
        top = stats[i, cv2.CC_STAT_TOP]
        width = stats[i, cv2.CC_STAT_WIDTH]
        height = stats[i, cv2.CC_STAT_HEIGHT]
        if area > 30:
            cv2.putText(frame, str(i), (left + 20, top + 20), cv2.FONT_HERSHEY_SIMPLEX, 1, (255, 0, 0), 2)
    dst4 = findObjectAndDraw(bImage4, frame)
    cv2.imshow('bImage4', bImage4)
    cv2.imshow('bImage4', dst4)
    key = cv2.waitKey(25)  # 0
    if key == 27:
        break
if cap.isOpened():
    cap.release()
cv2.destroyAllWindows()
print('*' * 80)
print(ap / t)
print('*' * 80)
