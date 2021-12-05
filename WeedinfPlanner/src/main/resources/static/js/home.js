fetch("http://localhost:8080/api/venues")
.then(responce=>responce.json())
.then(data=>{
    for (let venue of data) {
        let html=``;
        html+=`<div class="offer-grid animated-border col-md-2"">
                <div class="offer-image">
                    <a href="/offers/${venue.id}" class="image">
                        <section>
                                    <div class="carousel-item active">
                                        <div class="view">
                                            <img class="d-block w-100"
                                                 src="${venue.pictures[0].url}"
                                                 alt="slide">
                                        </div>
                                    </div>
                        </section>
                    </a>
                    <ul class="offer-links">
                        <li>
                            <a href="/offers/${venue.id}">
                                <i class="material-icons">visibility</i>
                            </a>
                        </li>
                    </ul>
                </div>
                <div class="offer-content">
                    <a class="link-title" href="/offers/${venue.id}">
                        <h3 class="offer-title"><a href="/offers/${venue.id}">${venue.title}
                        </a></h3>
                        <hr class="">
                        <h6 class="price-text">Price range:</h6>
                        <div class="price gold-text">${venue.minPrice} - ${venue.maxPrice}</div>
                </div>
            </div>`;
        $('#venues-container').append(html);
    }
});

fetch("http://localhost:8080/api/photographers")
    .then(responce=>responce.json())
    .then(data=>{
        for (let photographer of data) {
            let html=``;
            html+=`<div class="offer-grid animated-border col-md-2"">
                <div class="offer-image">
                    <a href="/offers/${photographer.id}" class="image">
                        <section>
                                    <div class="carousel-item active">
                                        <div class="view">
                                            <img class="d-block w-100"
                                                 src="${photographer.pictures[0].url}"
                                                 alt="slide">
                                        </div>
                                    </div>
                        </section>
                    </a>
                    <ul class="offer-links">
                        <li>
                            <a href="/offers/${photographer.id}">
                                <i class="material-icons">visibility</i>
                            </a>
                        </li>
                    </ul>
                </div>
                <div class="offer-content">
                    <a class="link-title" href="/offers/${photographer.id}">
                        <h3 class="offer-title"><a href="/offers/${photographer.id}">${photographer.title}
                        </a></h3>
                        <hr class="">
                        <h6 class="price-text">Price range:</h6>
                        <div class="price gold-text">${photographer.minPrice} - ${photographer.maxPrice}</div>
                </div>
            </div>`;
            $('#photographers-container').append(html);
        }
    });


fetch("http://localhost:8080/api/music")
    .then(responce=>responce.json())
    .then(data=>{
        for (let music of data) {
            let html=``;
            html+=`<div class="offer-grid animated-border col-md-2"">
                <div class="offer-image">
                    <a href="/offers/${music.id}" class="image">
                        <section>
                                    <div class="carousel-item active">
                                        <div class="view">
                                            <img class="d-block w-100"
                                                 src="${music.pictures[0].url}"
                                                 alt="slide">
                                        </div>
                                    </div>
                        </section>
                    </a>
                    <ul class="offer-links">
                        <li>
                            <a href="/offers/${music.id}">
                                <i class="material-icons">visibility</i>
                            </a>
                        </li>
                    </ul>
                </div>
                <div class="offer-content">
                    <a class="link-title" href="/offers/${music.id}">
                        <h3 class="offer-title"><a href="/offers/${music.id}">${music.title}
                        </a></h3>
                        <hr class="">
                        <h6 class="price-text">Price range:</h6>
                        <div class="price gold-text">${music.minPrice} - ${music.maxPrice}</div>
                </div>
            </div>`;
            $('#music-container').append(html);
        }
    });
