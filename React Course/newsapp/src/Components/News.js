import React, { Component } from "react";
import PropTypes from "prop-types";
import NewsItem from "./NewsItem";
import Spinner from "./Spinner";

export class News extends Component {
  static defaultProps = {
    country: "in",
    pageSize: 8,
    category: "general",
  };
  static propTypes = {
    country: PropTypes.string,
    pageSize: PropTypes.number,
    category: PropTypes.string,
  };
  constructor() {
    super();
    this.state = {
      articles: [],
      loading: true,
      page: 1,
    };
  }
  async componentDidMount() {
    let url = `https://newsapi.org/v2/top-headlines?country=${this.props.country}&category=${this.props.category}&apiKey=15053ae395a64e96995988ab11f5fe1b&page=1&pageSize=${this.props.pageSize}`;
    this.setState({ loading: true });
    let data = await fetch(url);
    let parsedData = await data.json();
    console.log(parsedData);
    this.setState({ articles: parsedData.articles, totalResults: parsedData.totalResults, loading: false });
  }
  handleNextClick = async () => {
    if (this.state.page + 1 > Math.ceil(this.state.totalResults / 30)) {
    } else {
      let url = `https://newsapi.org/v2/top-headlines?country=${this.props.country}&category=${this.props.category}&apiKey=15053ae395a64e96995988ab11f5fe1b&page=${this.state.page + 1}&pageSize=${
        this.props.pageSize
      }`;
      this.setState({ loading: true });
      let data = await fetch(url);
      let parsedData = await data.json();
      this.setState({ articles: parsedData.articles, page: this.state.page + 1, loading: false });
    }
  };
  handlePreviousClick = async () => {
    let url = `https://newsapi.org/v2/top-headlines?country=${this.props.country}&category=${this.props.category}&apiKey=15053ae395a64e96995988ab11f5fe1b&page=${this.state.page - 1}&pageSize=${
      this.props.pageSize
    }`;
    this.setState({ loading: true });
    let data = await fetch(url);
    let parsedData = await data.json();
    this.setState({ articles: parsedData.articles, page: this.state.page - 1, loading: false });
  };

  render() {
    return (
      <div className="container">
        <h2 className="my-3 text-center"> Top Headlines of the Day</h2>
        {this.state.loading && <Spinner></Spinner>}
        <div className="row my-3">
          {this.state.articles.map((element) => {
            return (
              <div className="col-3" key={element.url}>
                <NewsItem
                  title={element.title ? element.title.slice(0, 49) : "No title"}
                  description={element.description ? element.description.slice(0, 87) : "No description"}
                  imageUrl={element.urlToImage}
                  newsUrl={element.url}
                />
              </div>
            );
          })}
        </div>
        <div className="container d-flex justify-content-between">
          <button disabled={this.state.page <= 1} type="button" className="btn btn-dark" onClick={this.handlePreviousClick}>
            &larr;Previous
          </button>
          {!this.state.loading && (
            <p>
              Showing Page - {this.state.page} of {Math.ceil(this.state.totalResults / this.props.pageSize)}
            </p>
          )}
          <button disabled={this.state.page + 1 > Math.ceil(this.state.totalResults / this.props.pageSize)} type="button" className="btn btn-dark" onClick={this.handleNextClick}>
            Next&rarr;
          </button>
        </div>
      </div>
    );
  }
}

export default News;
