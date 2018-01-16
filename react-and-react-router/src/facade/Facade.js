class Facade {

    constructor(props) {
        this.repos = null;
        this.repo = null;
    }
    fetchAllData(cb) {
        if (!this.repos) {
            console.log('fetching new data');
            fetch('http://localhost:8084/React-and-React-Router-Maven/api/data').then((res) => {
                return res.json();
            }).then((json) => {
                this.repos = json;
                cb(this.repos);
            })
        } else {
            console.log("using stored data");
            cb(this.repos);
        }
    }

    getRepositoryFromName(name) {

        if (this.repos) {
            var arr = this.repos.filter((element) => {
                return  element.name === name;
            });
           return arr[0];
        }
    }
}
export default new Facade;