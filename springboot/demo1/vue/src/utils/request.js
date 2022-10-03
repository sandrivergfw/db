import axios from 'axios'


const request = axios.create({
    baseURL:'/api',
    timeout:5000
})

//request拦截器 对请求头进行处理
request.interceptors.request.use(config=>{
    config.headers['Content-Type'] = 'application/json;charset=utf-8';
    return config
},error => {
    return Promise.reject(error)
});

//对响应结果进行处理
request.interceptors.response.use(
    response=>{
        let res = response.data;
        if (response.config.responseType==='blob'){
            return res
        }
        if (typeof res === 'string'){
            res = res ? JSON.parse(res) :res
        }
        return res;
    },
    error => {
        console.log('err'+error)
        return Promise.reject(error)
    }
)

export default request