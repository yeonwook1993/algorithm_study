def floyd(a,n,path):
	for k in range(n) :
		for i in range(n) :
			for j in range(n) :
				if a[i][j] > a[i][k] + a[k][j] :
					path[i][j] = k
				a[i][j] = min(a[i][j],(a[i][k] + a[k][j]))
	return a

if __name__ == "__main__":
	Infinity = 1000000
	a = [[0,1,Infinity,1,5],
	[9,0,3,2,Infinity],
	[Infinity,Infinity,0,4,Infinity],
	[Infinity,Infinity,2,0,3],
	[3,Infinity,Infinity,Infinity,0]]



	p = []
	for i in range(5)	:
		line = []              
		for j in range(5):
			line.append(-1)    
		p.append(line)    
	
	b = floyd(a,5,p)
	print(b)
	print(p)