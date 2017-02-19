/**
 *
 * @param parentObj  父节点对象
 * @returns {Array}  该父节点下所有子节点的数组集合
 */
function getChildNodes(parentObj){
    var childNodes=parentObj.childNodes;
    var childs=[];
    for(var i=0;i<childNodes.length;i++){
        if(childNodes[i].nodeType==1){
            childs.push(childNodes[i]);
        }
    }
    return childs;
}

/**
 *
 * @param parentObj  父节点对象
 * @returns {*}   第一个子节点
 */
function getFirstChild(parentObj){
    var firstChild=parentObj.firstChild;
    if(firstChild.nodeType==3){
        return firstChild.nextSibling;
    }
    return firstChild;
}

/**
 *
 * @param parentObj  父节点对象
 * @returns {*}  最后一个子节点
 */
function getLastChild(parentObj){
    var lastChild=parentObj.lastChild;
    if(lastChild.nodeType==3){
        return lastChild.previousSibling;
    }
    return lastChild;
}
/**
 *
 * @param obj  元素节点
 * @returns {*}  该元素节点的下一个兄弟节点
 */
function getNextSibling(obj){
    var nextObj=obj.nextSibling;
    if(nextObj.nodeType==3){
        return nextObj.nextSibling;
    }
    return nextObj;
}

/**
 *
 * @param obj  元素节点
 * @returns {*}  该元素节点的上一个兄弟节点
 */
function getPreviousSibling(obj){
    var preObj=obj.previousSibling;
    if(preObj.nodeType==3){
        return preObj.previousSibling;
    }
    return preObj;
}


/**
 *
 * @param idOrName  如果传入的是id    前面加#     如果传入的是name  直接传
 * @returns {*}   根据id或name返回需要查找的元素节点
 */
function $(idOrName){
    if(idOrName.indexOf("#")==0){
        return document.getElementById(idOrName.substring(1));
    }else{
        return document.getElementsByName(idOrName);
    }
}