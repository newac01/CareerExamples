<?php  
//inputs a string will convert to ASCII number
function hex2int($string) {
    $length = strlen($string);
    $output = 0;
    //using strlen we can get the length of the string
    for ($i = 0; $i < $length; $i++) {
        $current = $string[$i];
        //if the character lies in 0 to 9 range
        if ( ($current >= '0') && ($current <= '9') )
            //using the function ord we can convert the first character into ASCII to change from character to integer
            //here we take the current value and we multiply it by 16 and subtract it from the ASCII of the lowest value
            $output = $output * 16 + ord($current) - ord('0');
            //handle upper case case.
            //character is between 'A' to 'F'
        elseif ( ($current >= 'A') && ($current <= 'F') )
            //multiply by 16 and subtract it by the ASCII of the lowest value 'A' and add 10
            $output = $output * 16 + ord($string[$i]) - ord('A') + 10;
            //repeat same procedure with the lowercase char case
        elseif ( ($current >= 'a') && ($current <= 'f') )
            $output = $output * 16 + ord($current) - ord('a') + 10;
    }

    return $output;
}
//function used like a toString() method
function convert($number){
    return "Converting: ".$number." to the following hexadecimal number: ".hex2int($number);
}

//Driver for function Hex2Dec
//will convert the number below into hex and add output message to the user
$hexNum = "D0F";
echo (convert($hexNum));
?>
