$(function(){

	var Human = Backbone.Model.extend({
	  initialize: function(){
	      alert("Welcome to this world");
	  }
	});
	var schema = new Backbone.Schema(Human);
	schema.define('m', { type: 'string' });


	var ApplicationRouter = Backbone.Router.extend({

		//map url routes to contained methods
		routes: {
			"": "home",
			"home.htm": "home",
			"about.htm": "about",
			"contact.htm": "contact"
		},

		deselectPills: function(){
			//deselect all navigation pills
			$('ul.pills li').removeClass('active');
		},

		selectPill: function(pill){
			//deselect all navigation pills
			this.deselectPills();
			//select passed navigation pill by selector
			$(pill).addClass('active');
		},

		hidePages: function(){
			//hide all pages with 'pages' class
			$('div.pages').hide();
		},

		showPage: function(page){
			//hide all pages
			this.hidePages();
			//show passed page by selector
			$(page).show();
		},

		home: function() {
			this.showPage('div#home-page');
			this.selectPill('li.home-pill');
		},

		about: function() {
			this.showPage('div#about-page');
			this.selectPill('li.about-pill');
		},

		contact: function() {
			this.showPage('div#contact-page');
			this.selectPill('li.contact-pill');
		}

	});

	var ApplicationView = Backbone.View.extend({

		//bind view to body element (all views should be bound to DOM elements)
		el: $('body'),

		//observe navigation click events and map to contained methods
		events: {
			'click ul.pills li.home-pill a': 'displayHome',
			'click ul.pills li.about-pill a': 'displayAbout',
			'click ul.pills li.contact-pill a': 'displayContact'
		},

		//called on instantiation
		initialize: function(){
			//set dependency on ApplicationRouter
			this.router = new ApplicationRouter();

			//call to begin monitoring uri and route changes
			Backbone.history.start({pushState: true})
		},

		displayHome: function(){
			//update url and pass true to execute route method
			this.router.navigate("home.htm", true);
		},

		displayAbout: function(){
			//update url and pass true to execute route method
			this.router.navigate("about.htm", true);
		},

		displayContact: function(){
			//update url and pass true to execute route method
			this.router.navigate("contact.htm", true);
		}

	});

	//load application
	new ApplicationView();

});
