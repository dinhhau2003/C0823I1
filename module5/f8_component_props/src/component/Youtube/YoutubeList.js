import React from 'react';
import {Data} from "../../data";
import YoutubeItem from "./YoutubeItem";

const YoutubeList = () => {
    return (
        <div>
            <div className="youtube-list">
                {Data.map((item, index)=>(
                    <YoutubeItem key={item.id} image={item.image} avatar={item.avatar} title={item.title} author={item.author}></YoutubeItem>
                ))}
            </div>
        </div>
    );
};

export default YoutubeList;