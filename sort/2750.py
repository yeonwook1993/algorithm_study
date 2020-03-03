n = int(input())
res = []
for i in range(n) :
	res.append(int(input()))
res.sort()

[print(i) for i in res]