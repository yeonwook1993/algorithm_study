n = int(input())
res = []
for i in range(n) :
	res.append(input())
res.sort()

[print(i) for i in res]