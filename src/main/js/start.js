import React from 'react';

export default class Hello extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            inputValue: "",
            currentTime: "",
            dateDelta: "",
            modifiedDate: "",
            timeDelta: "",
            modifiedTime: "",
            dateToFormat: "",
            formatedDate: ""

        };
        this.onInputBlur = this.onInputBlur.bind(this);
        this.onGetCurrentTimeClick = this.onGetCurrentTimeClick.bind(this);
        this.onModifiedDateClick = this.onModifiedDateClick.bind(this);
        this.onModifiedTimeClick = this.onModifiedTimeClick.bind(this);
        this.onFormatTheDateClick = this.onFormatTheDateClick.bind(this);
    }

    onInputBlur (event) {
        this.setState({inputValue: event.target.value});
    }

    onGetCurrentTimeClick () {
        fetch("/web-api/rest/current-time/" + this.state.inputValue, {
            method: "GET"
        }).then(response => {
            response.json().then(value => this.setState({currentTime: value}));
        });
    }

    onModifiedDateClick () {
        fetch("/web-api/rest/modified-date/" + this.state.dateDelta, {
            method: "GET"
        }).then(response => {
            response.text().then(value => this.setState({modifiedDate: value}));
        });
    }

    onModifiedTimeClick () {
        fetch("/web-api/rest/modified-time/" + this.state.timeDelta, {
            method: "GET"
        }).then(response => {
            response.text().then(value => this.setState({modifiedTime: value}));
        });
    }

    onFormatTheDateClick () {
        fetch("/web-api/rest/format-date/" + this.state.dateToFormat, {
            method: "GET"
        }).then(response => {
            response.text().then(value => this.setState({formatedDate: value}));
        });
    }

    render() {
        return (
            <div>
                <input type="text" placeholder="Type the country here" onBlur={this.onInputBlur}/>
                <button type="text" onClick={this.onGetCurrentTimeClick}> Get Current Time </button>
                <h3>{"Current time is: " + this.state.currentTime.dateTime}</h3>
                <div>
                    {"ay number in the year: " + this.state.currentTime.dayOfYear}
                </div>
                <div>
                    {"day number in the month: " + this.state.currentTime.dayOfMonth}
                </div>
                <div>
                    {"day number in the week: " + this.state.currentTime.dayOfWeek}
                </div>
                <div>
                    {"day of week name: " + this.state.currentTime.dayOfWeekName}
                </div>
                <div>
                    {"month number in the year: " + this.state.currentTime.monthOfYear}
                </div>
                <div>
                    {"month name: " + this.state.currentTime.monthName}
                </div>
                <div>
                    {"year: " + this.state.currentTime.year}
                </div>
                <div>
                    {"hours: " + this.state.currentTime.hours}
                </div>
                <div>
                    {"minutes: " + this.state.currentTime.minutes}
                </div>
                <div>
                    {"seconds: " + this.state.currentTime.seconds}
                </div>
                <div>
                    {"time zone offset: " + this.state.currentTime.timeZoneOffset}
                </div>
                <div>
                    {"time zone id: " + this.state.currentTime.timeZoneId}
                </div>
                <div>
                    {"time zone name: " + this.state.currentTime.timeZoneName}
                </div>
                <div>
                    {"time zone rules: " + this.state.currentTime.timeZoneRules}
                </div>

                <h3>{"Work with period class"}</h3>
                <div>
                    <input
                        type="text"
                        placeholder="Type number here to increase or decrease date"
                        onBlur={(event) => this.setState({dateDelta: event.target.value})}/>
                    <button onClick={this.onModifiedDateClick}> Show new date </button>
                    <div>
                        {this.state.modifiedDate ? this.state.modifiedDate : null}
                    </div>
                </div>
                <h3>Work with duration class</h3>
                <div>
                    <input
                        type="text"
                        placeholder="Type number here to increase or decrease hours"
                        onBlur={(event) => this.setState({timeDelta: event.target.value})}/>
                    <button onClick={this.onModifiedTimeClick}> Show new time here </button>
                    <div>
                        {this.state.modifiedTime ? this.state.modifiedTime : null}
                    </div>
                </div>
                <h3>Work with formatter class</h3>
                <div>
                    <input
                        type="text"
                        placeholder="type date in format: January 25 2016"
                        onBlur={(event) => this.setState({dateToFormat: event.target.value})}/>
                    <button onClick={this.onFormatTheDateClick}> Format my date </button>
                    <div>
                        {this.state.formatedDate ? this.state.formatedDate : null}
                    </div>
                </div>
            </div>
    );
    }
}

