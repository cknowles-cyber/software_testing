def triangle(a, b, c):
    if not (isinstance(a, int) and isinstance(b, int) and  isinstance(c, int)):
        print("Invalid")
        return
    
    if (a<=0 or b<=0 or c<=0):
        print("Invalid")
        return

    if (a+b<=c) or (a+c<=b) or (b+c<=a):
        print("Invalid")
        return

    if a == b and a == c:
        print("Equilateral")
    elif a != b and b != c and c != a:
        print("Scalene")
    elif (a == b and b != c) or (b == c and a != c) or (c == a and b != a):
        print("Isosceles")

triangle("G",5,2) # T1 non integer 
triangle(0,4,5) # T2 0 or negative value 
triangle(1,2,3) # T3 sides not be possible to be a triangle
triangle(4,4,4) # T4 equilateral
triangle(4,5,6) # T5 scalene
triangle(7,7,5) # T6 isosceles
