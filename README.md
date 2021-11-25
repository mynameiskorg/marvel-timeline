# Marvel Timeline

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
This app is for Marvel fan's who want to know the timeline of the Marvel movies. It also shows details of each movie from the Marvel Cinematic Universe.

### App Evaluation
- **Category:** Entertainment / Education
- **Mobile:** This app would be for Android devices. It will be designed to accomodate the mobile user experience.
- **Story:** Shows the timeline of the MCU movies in canonical order and in order of release date. The user can then select a movie on the timeline to learn about more details of the selected movie.
- **Market:** Any individual can download and use the app. It will be for those learning about the Marvel Cinematic Universe and passionate Marvel fans alike. 
- **Habit:** Users can use this as often as they would like. Initial exploration of the app can be done to learn more about the MCU. Further uses of the app can be used for reference and to find out about newly released movies.
- **Scope:** First, we would like to start up this app as an informational resource for those that would like to learn about Marvel. Later on, there is potential to expand the app to have forums for fans, comic conventions users can attend in their area, and a news feed for Marvel Studios announcements.


## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

- [x] Splash screen when user opens the app (Sprint 1)
- [x] List of movies in order that was intended and descriptions (Sprint 2)
- [x] Poster picture next to description (Sprint 2)
- [x] Ratings (Sprint 3)
- [x] Release Date (Sprint 2)
- [x] Trailers (Sprint 3)
- [ ] We need to be able to view horizontal and landscape mode


**Optional Nice-to-have Stories**
* Cast Members
* Details of the featured characters
* Add a likes button
* A comment option

### 2. Screen Archetypes

* Timeline Feed
   * List of movies in order that was intended and descriptions 
   * Poster picture next to description
* Movie Detail
   * Ratings
   * Release Date
   * Trailers

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Home Button

**Flow Navigation** (Screen to Screen)
* Title Page
    * Shows App name for 5 sec
* Stream
   * Poster Picture and short description
* Detail
   * OnClick Poster Picture, go to another page with more information regarding that movie

## Wireframes
<img src= "https://cdn.discordapp.com/attachments/901525263148531765/903813566396772362/20211029_181125.jpg" width=600>

### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Schema 
[This section will be completed in Unit 9]
### Models
#### Movie Info

| Property    | Type     | Description            |
| ----------- | -------- | ---------------------- |
| trailerURL  | String   | youtube url to trailer |
| posterImage | File     | poster image of movie  |
| title       | String   | title of movie         |
| releaseDate | DateTime | release date of movie  |
| rating      | Number   | rating of the movie    |
| description | String   | description of movie   |

#### Timeline Movie
| Property    | Type     | Description       |
| ----------- | -------- | ------------------|
| movieTitle  | String   | title of movie    |
| orderNumber | Number   | order in timeline |



### Networking
- Home Timeline Screen
    - (Read/GET) Get all Marvel movies
- Movie Detail Screen
    - (Read/GET) Get Marvel movie

#### [OPTIONAL] Existing API Endpoints
- Base URL - https://api.themoviedb.org/3/movie


| HTTP Verb | Endpoint          | Description                |
| --------- | ----------------- | -------------------------- |
| `GET`     | /movie/:id        | get details of movie by id |
| `GET`     | /movie/:id/videos | get movie videos by id     |

### GIFS
#### Sprint 1
##### Splash screen when user opens the app
<img src="splash_screen.gif" width="250px" alt="splash screen gif" title="Splash Screen"><br>
GIF created using [ScreenToGif](https://www.screentogif.com/).
#### Sprint 2
##### Timeline Activity
<img src="sprint2.gif" width="250px" alt="timeline screen gif" title="Timeline Screen"><br>
#### Sprint 3
##### Marvel movie detail screen
<img src="detail_screen.gif" width="250px" alt="detail screen gif" title="detail Screen"><br>
GIF created using [ScreenToGif](https://www.screentogif.com/).
