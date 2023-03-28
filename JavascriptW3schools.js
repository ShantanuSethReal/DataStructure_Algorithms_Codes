public class JavascriptW3schools {
    //********************************Introduction**************************
    document.getElementById("demo").innerHTML="Welcome to JavaScript";
    document.getElementById("demo").innerHTML='Welcome to JavaScript';
    document.getElementById("demo").src="./img/src.jpg";
    document.getElementById("demo").style.fontSize="35px";
    document.getElementById("demo").style.display="none";
    document.getElementById("demo").style.display="block";

    //******************************JavaScript Where To*********************
    <script type="text/javascript">
        document.getElementById("demo").innerHTML="Welcome to JavaScript";
    </script>
    Inline JS
    Javascript can be placed in head and body tag
    External JS
    <script src="myScript.js"></script>
    An external script can be referenced in 3 different ways:

        With a full URL (a full web address)<script src="https://www.w3schools.com/js/myScript.js"></script>
        With a file path (like /js/)<script src="/js/myScript.js"></script>
        Without any path <script src="myScript.js"></script>

    //***************************JS Output**********************************
    JavaScript can "display" data in different ways:
        Writing into an HTML element, using innerHTML.
        Writing into the HTML output using document.write().
        Writing into an alert box, using window.alert().
        Writing into the browser console, using console.log()

    //**************************JS Statements******************************* 
        JavaScript Programs
        A computer program is a list of "instructions" to be "executed" by a computer.In a programming language, these programming instructions are called statements.A JavaScript program is a list of programming statements.
        
        JavaScript Statements
        JavaScript statements are composed of Values, Operators, Expressions, Keywords, and Comments.
        
        Semicolons ;
        Semicolons separate JavaScript statements.
        
        JavaScript White Space
        JavaScript ignores multiple spaces. You can add white space to your script to make it more readable
        Keyword	Description
        var	    Declares a variable
        let	    Declares a block variable
        const	Declares a block constant
        if	    Marks a block of statements to be executed on a condition
        switch	Marks a block of statements to be executed in different cases
        for	    Marks a block of statements to be executed in a loop
        function()	Declares a function
        return	Exits a function
        try	    Implements error handling to a block of statements
}
//******************************JS Arrays*********************************** 
        const cars = ["Saab", "Volvo", "BMW"];
        const array_name = [item1, item2, ...]; 
        
        const cars = [
        "Saab",
        "Volvo",
        "BMW"
        ];
        
        const cars = [];
        cars[0]= "Saab";
        cars[1]= "Volvo";
        cars[2]= "BMW";
        
        const cars = new Array("Saab", "Volvo", "BMW");
        
        Accessing Array Elements
        
        You access an array element by referring to the index number:
        const cars = ["Saab", "Volvo", "BMW"];
        let car = cars[0];

        Arrays are Objects
        Arrays are a special type of objects. The typeof operator in JavaScript returns "object" for arrays.
        Object:
        const person = {
            firstName:"John", 
            lastName:"Doe", 
            age:46
        };

        Array Elements Can Be Objects
        JavaScript variables can be objects. Arrays are special kinds of objects.

        Array Properties and Methods
        cars.length   // Returns the number of elements
        cars.sort()   // Sorts the array

        const fruits = ["Banana", "Orange", "Apple"];
        fruits.push("Lemon");  // Adds a new element (Lemon) to fruits

        const fruits = ["Banana", "Orange", "Apple"];
        fruits[fruits.length] = "Lemon";  // Adds "Lemon" to fruits