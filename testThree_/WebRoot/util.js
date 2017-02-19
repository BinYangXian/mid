/**
 *
 * @param parentObj  ���ڵ����
 * @returns {Array}  �ø��ڵ��������ӽڵ�����鼯��
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
 * @param parentObj  ���ڵ����
 * @returns {*}   ��һ���ӽڵ�
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
 * @param parentObj  ���ڵ����
 * @returns {*}  ���һ���ӽڵ�
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
 * @param obj  Ԫ�ؽڵ�
 * @returns {*}  ��Ԫ�ؽڵ����һ���ֵܽڵ�
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
 * @param obj  Ԫ�ؽڵ�
 * @returns {*}  ��Ԫ�ؽڵ����һ���ֵܽڵ�
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
 * @param idOrName  ����������id    ǰ���#     ����������name  ֱ�Ӵ�
 * @returns {*}   ����id��name������Ҫ���ҵ�Ԫ�ؽڵ�
 */
function $(idOrName){
    if(idOrName.indexOf("#")==0){
        return document.getElementById(idOrName.substring(1));
    }else{
        return document.getElementsByName(idOrName);
    }
}