#boj3946.py
import sys
sys.setrecursionlimit(2000)
c={}
def go(n, f=0):
    key = n,f
    if n==0: return f
    if key not in c:
        ML=go(n-1,f+1)-1
        M=go(n-1,f)
        MR=go(n-1,max(f-1,0))+1
        c[key] = L*ML+R*MR+(1-L-R)*M
    return c[key]

for p in range(int(input())):
    n,L,R=map(float,input().split())
    print('%.4f' %go(n))
    c.clear()