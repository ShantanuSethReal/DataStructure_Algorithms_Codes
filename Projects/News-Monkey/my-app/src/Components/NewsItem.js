import React, { Component } from "react";
// import PropTypes from "prop-types";
import ing from "./Ing.jpg";
export class NewsItem extends Component {
  //   static propTypes = {};

  render() {
    let { title, description, imageUrl, newsUrl, author, date, source } = this.props;
    return (
      <>
        <div>
          <div className="card my-3">
            <span className="position-absolute top-0  translate-middle badge rounded-pill bg-danger" style={{ left: "85%", zIndex: "1" }}>
              {source}
              <span className="visually-hidden"></span>
            </span>
            <img src={imageUrl ? imageUrl : ing} className="card-img-top" alt="..." />
            <div className="card-body">
              <h5 className="card-title">{title}...</h5>
              <p className="card-text">{description}...</p>
              <p className="card-text">
                <small className="text-muted">
                  By {author} on {new Date(date).toGMTString()}{" "}
                </small>
              </p>
              <a href={newsUrl} rel="noreferrer" target="_blank" className="btn btn-primary">
                Read More
              </a>
            </div>
          </div>
        </div>
      </>
    );
  }
}

export default NewsItem;
