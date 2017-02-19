function test99(){
    document.write("<style>");
    document.write("td{border:solid black 1px}");
    document.write("</style>");
    document.write("<table>");
    for(var i=1;i<=9;i++){
        document.write("<tr>");
        for(var j=1;j<=i;j++){
            document.write("<td>");
            document.write(i+"*"+j+"="+i*j);
            document.write("</td>");
        }
        document.write("</tr>");
    }

    document.write("</table>");
}
function maopao(){

    var array=[43,31,321,43245,7657,561,321,23];
    document.write("老数组:"+array);
    for(var i=0;i<array.length-1;i++){
        for(var j=0;j<array.length-1-i;j++){
            if(array[j]>array[j+1]){
                var temp=array[j];
                array[j]=array[j+1];
                array[j+1]=temp;
            }
        }
    }
    document.write("<br/>新数组:"+array);
}