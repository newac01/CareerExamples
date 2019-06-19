<!DOCTYPE html>
<html>
    <head>
        
    </head>
    <meta charset="UTF-8">
    <title>This is a simple Calculator</title>
    <body>
        <form action="" method="GET">
            <input type="text" name="num1" placeholder="Number 1">
            <input type="text" name="num2" placeholder="Number 2">
        <select name="operator">
            <option>None</option>
            <option>Add</option>
            <option>Subtract</option>
            <option>Divide</option>
            <option>Multiply</option>
        </select>
        <br>
        <button type="submit" name="submit" value="submit">Calculate</button> 
        <p>The ANSWER is: </p>
        <?php
            if(isset($_GET["submit"])){
                $result1 = $_GET['num1'];
                $result2 = $_GET["num2"];
                $operator = $_GET["operator"];
                switch($operator){
                    case None:
                        echo "ERROR no number selected";
                    break;
                    case Add:
                        echo $result1 + $result2;
                    break;
                    case Subtract:
                        echo $result1 - $result2;
                    break;
                    case Divide:
                        echo $result1 / $result2;
                    break;
                    case Multiply:
                        echo $result1 * $result2;
                    break;
                    
                }
            }
        
        ?>
        </form>
        
    </body>
</html>