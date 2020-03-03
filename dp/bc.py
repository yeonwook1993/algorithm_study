def bin(a,b) :
	list = [] 
	for i in range(a+1)	:
		line = []              
		for j in range(b+1):
			if i == j :
				line.append(1)
			else :
				line.append(0)    
		list.append(line)    
 

	for i in range(a+1) :
		for j in range(min(i,b+1)) :
			if j > i :
				pass
			elif j == 0 or j == i :
				print(i,"  ",j)
				list[i][j] = 1
			else :
				print(i,"  ",j)
				list[i][j] = list[i-1][j-1] + list[i-1][j]
	return list


l = bin(5,3)
print(l[5][3])


