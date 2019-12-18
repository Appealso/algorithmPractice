#boj1057.py
n, j, h = map(int,input().split())
c=0
while(j!=h):
    j=(j//2)+(j%2)
    h=(h//2)+(h%2)
    c+=1
print(c)