$('#myButton').click(function(){
    let temp = $(this).parents("tr").find(".a");
    for (const iterator of temp) {
        console.log(iterator)
    }
})