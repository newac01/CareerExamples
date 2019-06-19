<!--Author: Aaron New-->
<!--Assignment: Homework12-->
<?php
    //array for selection
    $sources = array(
                "Google",
                "Friend",
                "Advert",
                "Other"
                );
?>
<!DOCTYPE html>
<html>
<body>
        
    <form action="" method="POST">
        <?php
        
       if(isset($_POST["submit"])){
           if(empty($_POST["name"]) 
           || empty($_POST["email"]) 
           || empty($_POST["source"]) 
           || empty($_POST["answer"]) 
           || empty($_POST["commentBox"]) 
           || empty($_POST["signUp"]))
           {
            echo "<h2 style=color:RED> You must fill out the form! </h2>"; 
           }else{
               //name of file
                //$filename = 'review.sql';
                //connect to db .php file
               require_once('db_con.php');
               //set values to what was sent via POST
               $name = $connection->real_escape_string($_POST['name']);
               $email = $connection->real_escape_string($_POST['email']);
               $source = $connection->real_escape_string($_POST['source']);
               $answer = $connection->real_escape_string($_POST['answer']);
               $comment = $connection->real_escape_string($_POST["commentBox"]);
               
               require_once('insert_data.php');
                
               header('Location: show_review.php');
           }
       }
        
        ?>
        <fieldset>
            <legend>
                Your Details:
            </legend>
            <label>
                Name: 
                <input name="name" style="width: 230px;" type="text" 
                    value = "<?php 
                        if (isset($_POST["name"])) 
						echo htmlspecialchars($_POST["name"]); 
						?>">
			</label><br/>
            <label>
                Email: 
                <input name="email" style="width: 230px;" type="text"
                    value = "<?php
                        if(isset($_POST["email"]))
                        echo htmlspecialchars($_POST["email"]);?>">
                        
            </label><br/>
        </fieldset>
        <br/>
        <fieldset>
            <legend>Your Review:</legend><br/>
            <label>How did you hear about us?
                <select name="source">
                    <?php
                        foreach($sources as $source){
                            if(isset($_POST["source"]) && $_POST["source"] == $source){
                                echo "<option selected='selected' value='$source'>$source</option>";
                            }else{
                                echo "<option value='$source'>$source</option>";
                            }
                        }
                    ?>
                </select>
            </label><br/><br/>
            <label>
                Would you visit again?<br/><input name="answer" type="radio" value="Yes" 
                    <?php if ((isset($_POST["answer"]) && $_POST["answer"] == "Yes")) 
								echo "checked"; ?>> Yes
            </label>
            <label>
                <input name="answer" type="radio" value="No"
                    <?php if ((isset($_POST["answer"]) && $_POST["answer"] == "No")) 
								echo "checked"; ?>> No
			</label>
            <label>
                <input name="answer" type="radio" value="Maybe"
                    <?php if ((isset($_POST["answer"]) && $_POST["answer"] == "Maybe")) 
								echo "checked"; ?>> Maybe
			</label><br/><br/>
                    
            <label>
                Comments: <br/>
                <textarea name="commentBox" cols="40" rows="4">
                    <?php
                        if(isset($_POST["commentBox"])){
                            echo htmlspecialchars($_POST["commentBox"]);
                        }
                    ?>
                </textarea>
            </label>
            <br/><br/>
            <label>
                <input name="signUp" type="checkbox" checked="true"> 
                Sign me up for email updates
            </label><br/>
            <label>
                <input type="submit" name="submit" value="Submit Review">
            </label>
            
        </fieldset>
    </form>
</body>

</html>
