/**
 * 
 */

const getContextPath=()=>{
  const host = location.host;
  const url= location.href;
  const begin = url.indexOf(host)+host.length;
  const end = url.indexOf('/', begin +1);
  return url.substring(begin,end);
}


const getDateTime = ()=>{
  const type = document.getElementById('type');
  if(type.value === 'date'){
    location.href = '/mvc/getDate.do';
  } else if(type.value === 'time'){
    location.href = '/mvc/getTime.do';
  } else if(type.value === 'datetime'){
    location.href = '/mvc/getDateTime.do';
  }
}

document.getElementById('btn').addEventListener('click', getDateTime);
