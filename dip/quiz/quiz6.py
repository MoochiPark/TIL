# 0704.py quiz5
import cv2
import numpy as np

#1

#2
src2 = cv2.imread('../data/wheel.jpg')
gray2 = cv2.cvtColor(src2,cv2.COLOR_BGR2GRAY)
circles2 = cv2.HoughCircles(gray2, method = cv2.HOUGH_GRADIENT,
          dp=1, minDist=50, param2=15, minRadius=145, maxRadius=150)

print('circles2.shape=', circles2.shape)
for circle in circles2[0,:]:
    cx, cy, r  = circle
    cv2.circle(src2, (cx, cy), r, (0,0,255), 2)
cv2.imshow('src2',  src2)
cv2.waitKey()
cv2.destroyAllWindows()
