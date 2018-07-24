<html>
<body>

<form action="/myservlet/servlet">
    Press the "READ" button to read all users from the DB.<br>
    <input type="hidden" name="action" value="R">
    <input type="submit" value="READ">
</form>
<br>-------------------------------------------------<br><br>
<form action="/myservlet/servlet">
    To add a new user please fill up the fields and press the "ADD" button.<br>
    <input type="hidden" name="action" value="C">
    <input type="text" name="nume" placeholder="Name"><br>
    <input type="text" name="telefon" placeholder="Phone Number"><br>
    <input type="submit" value="ADD">
</form>
<br>-------------------------------------------------<br><br>
<form action="/myservlet/servlet">
    To delete an user please fill up the field and press the "DELETE" button.<br>
    <input type="hidden" name="action" value="D">
    <input type="text" name="nume" placeholder="Name"><br>
    <input type="submit" value="DELETE">
</form>

</body>
</html>
