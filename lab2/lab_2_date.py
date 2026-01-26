def isLeapYear(year):
    return True # Set to true for simplicity, program not focused on checking for leap year
    # return False
def date(day, month, year):
    if not (isinstance(day, int) and isinstance(month, int) and  isinstance(year, int)):
        print("Invalid")
        return
    
    if year <=0:
        print("Invalid")
        return
    
    if month <=0 or month >12:
        print("Invalid")
        return
    
    if day <=0 or day >31:
        print("Invalid")
        return
    
    if month == 2:
        if isLeapYear(year):
            if day>29:
                print("Invalid")
                return
        else: 
            if day>28:
                print("Invalid")
                return
    
    if month in [4,6,9,11] and day>30:
        print("Invalid")
        return
    
    print("Valid")
    
date("C",2,5) # T1 non integer
date(4,3,-1) # T2 0 or negative value year
date(4,13,2000) # T3 Greater than 12 or less than 0 value month 
date(-1,4,2005) # T4 Greater than 31 or less than 0 value day
date(30,2,2005) # T5 Leap year true and greater than 29 days February
date(29,2,2009) # T6 Leap year false and greater than 28 days February
date(31,4,2022) # T7 Greater than 30 days for months 4,6,9, or 11
date(31,1,2026) # T8 Valid date entered