<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Botiga</title>
<style type="text/css">
	body{
	text-align: center;
    background-color: cyan
}
.nameForm{
    text-align: center;
    border: 1px solid black;
    margin: 0 auto;
    width: 400px;
    background-color: red;
}
.img{
    
    display: inline-block;
    margin-left: 10px;
}
.img1{
    margin-left: 30px;
}

#money{
    text-align: center;
    border: 1px solid black;
    background-color: yellow;
    margin: 0 auto;
    width: 400px;
}
.txt{
    background-color: yellow;
    width: 80px;
    border: 1px solid black;
}
</style>
</head>
<body>
	<form action="">
            <h1 class="nameForm">Form Productos Available</h1><br>
            
                <div class="img">IMG1</div>
                <div class="img">IMG2</div>
                <div class="img">IMG3</div>
                <div class="img">IMG4</div>
                <div class="img">IMG5</div><br>
                
                    <input type="checkbox" name="img1" class="img1">
                    <input type="checkbox" name="img1" class="img1">
                    <input type="checkbox" name="img1" class="img1">
                    <input type="checkbox" name="img1" class="img1">
                    <input type="checkbox" name="img1" class="img1">
                
                <br><br><br><br><br>
           
            <div id="money">
                <h2>Payment Mode:</h2>
                <input type="radio" name="pago" class="pay">Cash
                <input type="radio" name="pago" class="pay" checked >Credit Card
                <input type="radio" name="pago" class="pay">Paypal
            </div><br><br>
            <div>
                <label class="txt">Nick: </label>
                <input type="text" name="nick" id="nick">
                <label class="txt">Comments: </label>
                <input type="text" name="comments">
            </div><br><br>
           <label class="txt">Quantity </label><select name="Quanity" id="">
                <option value="1">1</option>
                <option value="2">2</option>
                <option value="3">3</option>
                <option value="4">4</option>
                <option value="5">5</option>
                <option value="6">6</option>
                <option value="7">7</option>
                <option value="8">8</option>
                <option value="9">9</option>
                <option value="10">10</option>
            </select><br><br>
            <input type="submit" value="Send"/>
            <input type="submit" value="Delete"/>
    </form>
</body>
</html>