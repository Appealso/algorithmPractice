import itertools
c=0
N,S = map(int, input().split())
set = list(map(int,input().split()))
for i in range(1,N+1):
    sets = itertools.combinations(set,i)
    for j in sets:
        if sum(j)==S: c+=1
print(c)