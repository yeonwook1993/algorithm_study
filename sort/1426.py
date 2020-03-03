s = int(input())
a = list(map(int,input().split()))
b = list(map(int,input().split()))

a.sort()
L = []
loc = 0
for i in range(s-1) :
	
	while True :
		if loc not in L :
			break;
		else :
			loc = loc +1

	for j in range(s) :
		if b[loc] < b[j] and j not in L :
			loc = j
	L.append(loc)
	loc = 0
for i in range(s) :
	if i not in L :
		L.append(i)

res = 0
for i in range(s) :
	res = res + a[i]*b[L[i]]
print(res)


'''
0 1 1 1 6

8 7 3 2 1

2 7 8 3 1

1.a를 정렬해!
2. b 의 가장 큰 위치를 찾는다.
3. a의 가장 작은 값을 해당 위치로
4. 변경된 위치의 값은 따로 저장해 쳐다 보지 않기로
'''