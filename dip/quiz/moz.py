import cv2
import numpy as np
src = cv2.imread('../data/lena.jpg')
rects = cv2.selectROI(src)
# rects = cv2.selectROIs(src) 책에있슴
print('rects = ', rects)

# for r in rects:
#     cv2.rectangle(src, (r[0], r[1]), (r[0] + r[2], r[1] + r[3]), 255)

# img = src[r[1]: r[1] + r[3], r[0]:r[0] + r[2]]
# cv2.imshow('img', img)
# cv2.waitKey()

# dst = np.zeros(img.shape, dtype = img.dtype)
dst2 = np.zeros(src.shape, dtype = src.dtype)

N = 32
height, width, _ = src.shape

h = rects[3] // N
w = rects[2] // N
for i in range(N):
    for j in range(N):
        y = i * h + rects[1] + 5
        x = j * w + rects[0] + 5
        roi = src[y:y+h, x:x+w]
        src[y:y+h, x:x+w] = cv2.mean(roi)[0:3]




print(height, width)
cv2.imshow('src', src)

cv2.waitKey()
cv2.destroyAllWindows()