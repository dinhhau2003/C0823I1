import {logDOM} from "@testing-library/react";

function YoutubeItem(props){
    // console.log(props)
    return(
        <div className={"youtube-item"}>
            <div className={"youtube-image"}>
                <img src={props.image}/>
            </div>
            <div className={"youtube-footer"}>
                <img className={"youtube-avatar"} src={props.avatar}/>
                <div className={"youtube-info"}>
                    <h3 onClick={()=> console.log(props.title)} className={"youtube-title"}>
                        {props.title}
                    </h3>
                    <h4 className={"youtube-author"}>{props.author}</h4>
                </div>
            </div>
        </div>
    )
}
export default YoutubeItem;