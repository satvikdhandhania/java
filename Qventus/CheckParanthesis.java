/*

Author Satvik Dhandhania Date 5th May 2017
Qventus

Test cases - Inputs:
	1.	{} - valid 
	2.	{ - invalid 
	3.	Abcd  - Valid  
	4.	[werwe {rtfw(abc )}] - Valid 
	5.	[werwe {rtfw(abc} )] - Invalid 
	6.	[ ( asfd)  - Invalid  
	7.	[ ( asf ) ] } - Invalid  
	8.	[fsd ()]fdsd  [fsd ] dsf  [fsd ] - Valid  

{ [ (

Input 
{ a 1 [ ] } 

Output:
Valid

Input:
{ ]

Output:
Invalid

*/

boolean  checkBrackets(String s){

Stack<char> stack = new Stack<char>();
if(s == null){
    Return false;
}
stack.clear();

Char [] input_array = s.toArray();

Int len = input_array.length();
for(int i=0; i<len;i++){
if((input_array[i] == ‘(‘ ) || (input_array[i] == ‘{‘ ) || (input_array[i] == ‘[‘ )){
    stack.push(input_array[i]);
}
if((input_array[i] == ‘)‘ ) || (input_array[i] == ‘}’ ) || (input_array[i] == ‘]‘ )){
    if(stack.isEmpty()){
    Return false;
	}
    Char ch = stack.pop();
    if(( ch == ‘(’) && (input_array[i] != ‘)‘ )){
        Return false;
    }
    if(( ch == ‘{’) && (input_array[i] != ‘}‘ )){
        Return false;
    }
    if(( ch == ‘[’) && (input_array[i] != ‘]‘ )){
        Return false;
    }
}
if(!stack.isEmpty()){
	return false;
}

return true; 
}

















