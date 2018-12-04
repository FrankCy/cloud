layui.config({
    base : "js/"
}).use(['form','layer','jquery','laypage'],function(){
    var form = layui.form(),
        layer = parent.layer === undefined ? layui.layer : parent.layer,
        laypage = layui.laypage,
        $ = layui.jquery;

    //加载页面数据
    var userData = '';
    $.get("userList", function(data){
        userData = data;
        userList();
    })


    //全选
    form.on('checkbox(allChoose)', function(data){
        var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
        child.each(function(index, item){
            item.checked = data.elem.checked;
        });
        form.render('checkbox');
    });

    //通过判断文章是否全部选中来确定全选按钮是否选中
    form.on("checkbox(choose)",function(data){
        var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"])');
        var childChecked = $(data.elem).parents('table').find('tbody input[type="checkbox"]:not([name="show"]):checked')
        if(childChecked.length == child.length){
            $(data.elem).parents('table').find('thead input#allChoose').get(0).checked = true;
        }else{
            $(data.elem).parents('table').find('thead input#allChoose').get(0).checked = false;
        }
        form.render('checkbox');
    })

    //是否展示
    form.on('switch(isShow)', function(data){
        var index = layer.msg('修改中，请稍候',{icon: 16,time:false,shade:0.8});
        setTimeout(function(){
            layer.close(index);
            layer.msg("展示状态修改成功！");
        },2000);
    })

    function userList(that){
        //渲染数据
        function renderDate(data,curr){
            var dataHtml = '';
            if(!that){
                currData = userData.concat().splice(curr*nums-nums, nums);
            }else{
                currData = that.concat().splice(curr*nums-nums, nums);
            }
            if(currData.length != 0){
                for(var i=0;i<currData.length;i++){
                    dataHtml += '<tr>'
                        +'<td><input type="checkbox" name="checked" lay-skin="primary" value="'+ currData[i].id +'" lay-filter="choose"></td>'
                        +'<td>'+currData[i].username+'</td>'
                        +'<td>'+currData[i].email+'</td>';
                    dataHtml += '<td>'+currData[i].nickname+'</td>';
                    dataHtml += '<td>'+currData[i].registerTime+'</td>';
                    dataHtml +='</tr>';
                }
            }else{
                dataHtml = '<tr><td colspan="5">暂无数据</td></tr>';
            }
            return dataHtml;
        }

        //分页
        var nums = 20; //每页出现的数据量
        if(that){
            userData = that;
        }
        laypage({
            cont : "page",
            pages : Math.ceil(userData.length/nums),
            jump : function(obj){
                $(".user_content").html(renderDate(userData,obj.curr));
                $('.user_list thead input[type="checkbox"]').prop("checked",false);
                form.render();
            }
        })
    }
})
