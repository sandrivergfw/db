import {ajax} from "jquery";

declare let $: (selector: string) => any;
declare let ajax:(selector:string)=>any;
declare let jQuery: (selector: string) => any;
declare namespace jQuery{
    function ajax(selector: string):any;
}