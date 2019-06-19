
<!DOCTYPE html>
<style>
    .review {
    margin: auto;
    width: 70%
}

table {
    width: auto;
}

table, td,th{border:1px solid;
}
th {
    letter-spacing: 0.1em;
    font-size: 90%;
}

</style>
<html>
    <head>
        
    </head>
    <body>
        <?php
            require_once("db_con.php");
            require_once("select_data.php");
            
            
            echo "<table id='review'>
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>email</th>
                    <th>referrer</th>
                    <th>rating</th>
                    <th>comments</th>
                </tr>";
            while($user = $result->fetch_assoc()){
                echo"<tr>
                        <td>" . $user["id"] . "</td>
                        <td>" . $user["name"] . "</td>
                        <td>" . $user["email"] . "</td>
                        <td>" . $user["referrer"] . "</td>
                        <td>" . $user["rating"] . "</td>
                        <td>" . $user["comment"] . "</td>
                    </tr>";
            }
            echo "<table>";
        require_once("part1hw12.php");
        ?>
    </body>
</html>