import React from 'react';

export default class Hello extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            inputValue: ""
        };
        this.onInputBlur = this.onInputBlur.bind(this);
        this.onGetCurrentTimeClick = this.onGetCurrentTimeClick.bind(this);
    }

    onInputBlur (event) {
        this.setState({inputValue: event.target.value});
    }

    onGetCurrentTimeClick () {
        fetch("/web-api/hello/stas", {
            method: "GET"
        }).then((response) => console.log(response));
    }

    render() {
        console.log(this.state.inputValue);
        return (
            <div>
                <input type="text" placeholder="Type the country here" onBlur={this.onInputBlur}/>
                <button type="text" onClick={this.onGetCurrentTimeClick}> Get Current Time </button>
                <h1>We are going to win</h1>
            </div>
    );
    }
}

