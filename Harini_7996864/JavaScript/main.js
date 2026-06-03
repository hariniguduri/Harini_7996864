// Task 1

console.log("Welcome to the Community Portal");

window.onload = function () {
  alert("Page fully loaded");
};

// Task 2

const eventName = "Music Night";
const eventDate = "10-06-2026";
let seats = 50;

let eventText = `Event: ${eventName} | Date: ${eventDate} | Seats: ${seats}`;

document.getElementById("eventInfo").innerHTML = eventText;

seats++;

// Task 3

let events = [
  {
    name: "Music Night",
    date: "2026-06-10",
    seats: 20,
    category: "Music",
  },
  {
    name: "Old Event",
    date: "2024-01-01",
    seats: 0,
    category: "Workshop",
  },
  {
    name: "Baking Workshop",
    date: "2026-07-15",
    seats: 10,
    category: "Workshop",
  },
];

events.forEach(function (event) {
  let today = new Date();
  let eventDay = new Date(event.date);

  if (eventDay > today && event.seats > 0) {
    let p = document.createElement("p");

    p.innerHTML = event.name + " seats available";

    document.getElementById("validEvents").appendChild(p);
  } else {
    console.log(event.name + " hidden");
  }
});

try {
  function registerSeat(eventObj) {
    if (eventObj.seats <= 0) {
      throw new Error("No seats available");
    }

    eventObj.seats--;
  }

  registerSeat(events[0]);
} catch (error) {
  console.log(error.message);
}

// Task 4

function addEvent(name, date, category) {
  events.push({
    name: name,
    date: date,
    seats: 15,
    category: category,
  });
}

function filterEventsByCategory(category, callback) {
  let filtered = events.filter(function (item) {
    return item.category === category;
  });

  callback(filtered);
}

function showMusicEvents() {
  filterEventsByCategory("Music", function (data) {
    console.log(data);
  });
}

function registrationTracker() {
  let count = 0;

  return function () {
    count++;

    document.getElementById("totalCount").innerHTML =
      "Total Music Registrations: " + count;
  };
}

let musicCounter = registrationTracker();

// Task 5

function Event(name, seats) {
  this.name = name;
  this.seats = seats;
}

Event.prototype.checkAvailability = function () {
  return this.seats > 0 ? "Seats Available" : "Full";
};

let obj1 = new Event("Dance Show", 25);

let objectText = "";

Object.entries(obj1).forEach(function (item) {
  objectText += item[0] + " : " + item[1] + "<br>";
});

objectText += obj1.checkAvailability();

document.getElementById("objectData").innerHTML = objectText;

// Task 6

let allEvents = [];

allEvents.push("Music Night");
allEvents.push("Baking Workshop");

let musicOnly = events.filter(function (item) {
  return item.category === "Music";
});

let cardNames = allEvents.map(function (item) {
  return "Workshop on " + item;
});

document.getElementById("arrayData").innerHTML = cardNames.join("<br>");

// Task 7

let container = document.querySelector("#eventContainer");

events.forEach(function (item) {
  let div = document.createElement("div");

  div.classList.add("eventCard");

  div.innerHTML = `
    <h3>${item.name}</h3>
    <p>${item.category}</p>

    <button onclick="registerUser('${item.name}')">
    Register
    </button>

    <button onclick="cancelRegistration('${item.name}')">
    Cancel
    </button>
    `;

  container.appendChild(div);
});

function registerUser(eventName) {
  document.getElementById("formMessage").innerHTML =
    "Registered for " + eventName;

  musicCounter();
}

function cancelRegistration(eventName) {
  document.getElementById("formMessage").innerHTML =
    "Cancelled for " + eventName;
}

// Task 8

document.getElementById("categoryFilter").onchange = function () {
  let selectedCategory = this.value;

  let filteredEvents = events.filter(function (item) {
    return selectedCategory === "all" || item.category === selectedCategory;
  });

  document.getElementById("eventContainer").innerHTML = filteredEvents
    .map(function (item) {
      return item.name;
    })
    .join("<br>");
};

document.getElementById("searchBox").addEventListener("keydown", function () {
  let searchText = this.value.toLowerCase();

  let searchedEvents = events.filter(function (item) {
    return item.name.toLowerCase().includes(searchText);
  });

  document.getElementById("eventContainer").innerHTML = searchedEvents
    .map(function (item) {
      return item.name;
    })
    .join("<br>");
});

// Task 9

function getEvents() {
  document.getElementById("loading").innerHTML = "Loading...";

  fetch("https://jsonplaceholder.typicode.com/posts/1")
    .then(function (response) {
      return response.json();
    })

    .then(function (data) {
      document.getElementById("loading").innerHTML = "";

      document.getElementById("apiData").innerHTML =
        "Events fetched successfully";
    })

    .catch(function (error) {
      console.log(error);
    });
}

async function fetchData() {
  try {
    let response = await fetch("https://jsonplaceholder.typicode.com/posts/2");

    let data = await response.json();

    console.log(data);
  } catch (error) {
    console.log(error);
  }
}

fetchData();

// Task 10

function showEvent(user = "Guest") {
  return user;
}

let eventObj = {
  eventTitle: "Food Festival",
  place: "Hyderabad",
};

let { eventTitle, place } = eventObj;

let copiedEvents = [...events];

document.getElementById("modernData").innerHTML = eventTitle + " " + place;

// Task 11

document
  .getElementById("registerForm")
  .addEventListener("submit", function (event) {
    event.preventDefault();

    console.log("Form Submitted");

    let form = event.target;

    let name = form.elements["userName"].value;
    let email = form.elements["userEmail"].value;
    let selectedEvent = form.elements["userEvent"].value;
    console.log("Name:", name);
    console.log("Email:", email);
    console.log("Selected Event:", selectedEvent);
    document.getElementById("nameError").innerHTML = "";
    document.getElementById("emailError").innerHTML = "";
    document.getElementById("eventError").innerHTML = "";

    let valid = true;

    if (name === "") {
      document.getElementById("nameError").innerHTML = "Enter name";

      valid = false;
    }

    if (email === "") {
      document.getElementById("emailError").innerHTML = "Enter email";

      valid = false;
    }

    if (selectedEvent === "") {
      document.getElementById("eventError").innerHTML = "Select event";

      valid = false;
    }

    if (valid) {
      document.getElementById("formMessage").innerHTML =
        "Registration Successful";
    }
  });

// Task 12

function sendData() {
  let form = document.getElementById("registerForm");

  let userData = {
    name: form.elements["userName"].value,
    event: form.elements["userEvent"].value,
  };

  console.log("Sending Data");
  console.log("Fetch Payload:", userData);

  setTimeout(function () {
    fetch("https://jsonplaceholder.typicode.com/posts", {
      method: "POST",

      headers: {
        "Content-Type": "application/json",
      },

      body: JSON.stringify(userData),
    })
      .then(function (response) {
        return response.json();
      })

      .then(function (data) {
        console.log(data);

        document.getElementById("serverMessage").innerHTML =
          "Data sent successfully";
      })

      .catch(function (error) {
        document.getElementById("serverMessage").innerHTML =
          "Failed to send data";

        console.log(error);
      });
  }, 2000);
}

// Task 13

console.log("Debugging Started");
console.log("Check Network Tab");

// Task 14

$("#registerBtn").click(function () {
  console.log("jQuery Button Clicked");
});

$("#hideBtn").click(function () {
  $(".jqCard").fadeOut();
});

$("#showBtn").click(function () {
  $(".jqCard").fadeIn();
});
