import React, { Component } from 'react'
import { Link } from 'react-router-dom'

export default class Login extends Component {



    render() {
        return (
            <div>
                <center><h1>Login</h1></center>
                <Link to="/signup">
                    <button variant="outlined">
                        signup
                    </button>
                </Link>
            </div>
        )
    }

}