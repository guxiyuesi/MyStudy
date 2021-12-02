$('myButton').click('click', function(){
    let temp = $(this).parents("tr").find(".a").val();
    alert("hello");
})