function removeItem(x)
{
	$.ajax(
		{	
			url:"/user/deleteItem",
			data:{'iId':x},
			success:function()
			{
				$('#'+x).remove();
			},
			error:function(data,status)
			{
				alert("删除失败："+status);
			}
		});
}