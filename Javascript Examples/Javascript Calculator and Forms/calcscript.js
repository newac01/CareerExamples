    //subtract function
    function sub() {
        var x = Number(document.calculator.num1.value);
        var y = Number(document.calculator.num2.value);
        var c = Number;
        c = x - y;
        document.calculator.result.value = c;
    }

    //multiply function
    function multiply() {
        var x = Number(document.calculator.num1.value);
        var y = Number(document.calculator.num2.value);
        var c = Number;
        c = x * y;
        document.calculator.result.value = c;
    }

    //divide function
    function divide(){
       var x = Number(document.calculator.num1.value);
        var y = Number(document.calculator.num2.value);
        var c = Number;
        c = x / y;
        document.calculator.result.value = c;
    }

    //add function
    function add(){
        var x = Number(document.calculator.num1.value);
        var y = Number(document.calculator.num2.value);
        var c = Number;
        c = x + y;
        document.calculator.result.value = c;
    }
   