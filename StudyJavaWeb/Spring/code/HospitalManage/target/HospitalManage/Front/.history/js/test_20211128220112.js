$('#myButton').click(function(){
    let temp = $(this).parents("tr").find(".a");
    console.log(temp.eq(0).text());
})