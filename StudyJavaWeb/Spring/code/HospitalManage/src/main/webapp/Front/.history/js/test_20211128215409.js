$('#myButton').click(function(){
    let temp = $(this).parents("tr").find(".a").val();
    console.log(temp);
})