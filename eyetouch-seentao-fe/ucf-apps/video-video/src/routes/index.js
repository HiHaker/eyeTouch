import React from "react";
import {Route} from "mirrorx";
import indexContainer from './IndexView/container';
import mainContainer from './MainModal/container';
import BpmChartContainer from './bpmChart/container';

export default () => (
    <div className="route-content">
        <Route exact path='/' component={indexContainer}/>
        <Route path='/main' component={mainContainer}/>
        <Route  path={`/bpm-chart`} component={BpmChartContainer} />
    </div>

)
