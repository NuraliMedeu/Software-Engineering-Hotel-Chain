--
-- PostgreSQL database dump
--

-- Dumped from database version 13.4
-- Dumped by pg_dump version 13.4

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: btree_gist; Type: EXTENSION; Schema: -; Owner: -
--

CREATE EXTENSION IF NOT EXISTS btree_gist WITH SCHEMA public;


--
-- Name: EXTENSION btree_gist; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION btree_gist IS 'support for indexing common datatypes in GiST';


SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: bookings; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.bookings (
    id integer NOT NULL,
    email text,
    hotel_id integer,
    room_number integer,
    floor integer,
    check_in date,
    check_out date,
    CONSTRAINT dates_check CHECK ((check_in < check_out))
);


ALTER TABLE public.bookings OWNER TO postgres;

--
-- Name: bookings_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.bookings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;


ALTER TABLE public.bookings_id_seq OWNER TO postgres;

--
-- Name: destinations; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.destinations (
    city text NOT NULL
);


ALTER TABLE public.destinations OWNER TO postgres;

--
-- Name: hotel_phones; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hotel_phones (
    id integer NOT NULL,
    phone_number character varying(15) NOT NULL
);


ALTER TABLE public.hotel_phones OWNER TO postgres;

--
-- Name: hotel_room_types; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hotel_room_types (
    id integer NOT NULL,
    type text NOT NULL,
    size real,
    capacity integer
);


ALTER TABLE public.hotel_room_types OWNER TO postgres;

--
-- Name: hotel_rooms; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hotel_rooms (
    id integer NOT NULL,
    room_number integer NOT NULL,
    floor integer NOT NULL,
    type text,
    available boolean,
    cleaned boolean
);


ALTER TABLE public.hotel_rooms OWNER TO postgres;

--
-- Name: hotels; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hotels (
    id integer NOT NULL,
    name text,
    destination text
);


ALTER TABLE public.hotels OWNER TO postgres;

--
-- Name: hotels_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.hotels_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    MAXVALUE 2147483647
    CACHE 1;


ALTER TABLE public.hotels_id_seq OWNER TO postgres;

--
-- Name: identification_types; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.identification_types (
    id integer NOT NULL,
    name text
);


ALTER TABLE public.identification_types OWNER TO postgres;

--
-- Name: identification_types_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.identification_types_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.identification_types_id_seq OWNER TO postgres;

--
-- Name: identification_types_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.identification_types_id_seq OWNED BY public.identification_types.id;


--
-- Name: managers; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.managers (
    hotel_id integer NOT NULL,
    manager_email text
);


ALTER TABLE public.managers OWNER TO postgres;

--
-- Name: supervised; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.supervised (
    manager_email text NOT NULL,
    employee_email text NOT NULL
);


ALTER TABLE public.supervised OWNER TO postgres;

--
-- Name: user_types; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.user_types (
    name text NOT NULL
);


ALTER TABLE public.user_types OWNER TO postgres;

--
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    email text NOT NULL,
    name text,
    surname text,
    identification_type integer,
    identification_number text,
    user_type text NOT NULL,
    password text
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: identification_types id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.identification_types ALTER COLUMN id SET DEFAULT nextval('public.identification_types_id_seq'::regclass);


--
-- Data for Name: bookings; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.bookings (id, email, hotel_id, room_number, floor, check_in, check_out) FROM stdin;
1	zakhar.semenov@nu.edu.kz	1	1	1	2021-12-08	2021-12-10
2	zakhar.semenov@nu.edu.kz	1	2	1	2021-12-08	2021-12-10
3	galymzhan.baltabay@nu.edu.kz	4	1	1	2021-12-08	2021-12-20
4	zakhar.semenov@nu.edu.kz	4	2	1	2021-12-12	2021-12-18
\.


--
-- Data for Name: destinations; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.destinations (city) FROM stdin;
Almaty
Nur-Sultan
Shimkent
\.


--
-- Data for Name: hotel_phones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hotel_phones (id, phone_number) FROM stdin;
1	123-123
1	321-321
2	333-000
3	001-001
4	007-666
4	123-456
\.


--
-- Data for Name: hotel_room_types; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hotel_room_types (id, type, size, capacity) FROM stdin;
1	single	10	1
1	double	15	2
1	king	25	4
2	single	7	1
2	double king	30	2
2	family	30	4
3	single	6	1
4	double	12	2
\.


--
-- Data for Name: hotel_rooms; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hotel_rooms (id, room_number, floor, type, available, cleaned) FROM stdin;
1	1	1	single	t	f
1	2	1	single	t	f
1	3	1	single	t	f
1	4	1	single	t	f
1	1	2	double	t	f
1	2	2	double	t	f
1	1	3	king	t	f
2	1	1	single	t	f
2	2	1	single	t	f
2	3	1	single	t	f
2	4	1	single	t	f
2	1	2	double king	t	f
2	2	2	double king	t	f
2	1	3	family	t	f
3	1	1	single	t	f
3	2	1	single	t	f
3	3	1	single	t	f
3	4	1	single	t	f
4	1	1	double	t	f
4	2	1	double	t	f
\.


--
-- Data for Name: hotels; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hotels (id, name, destination) FROM stdin;
1	Rixos	Almaty
2	Elite	Nur-Sultan
3	Royal	Shimkent
4	Mercure	Almaty
\.


--
-- Data for Name: identification_types; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.identification_types (id, name) FROM stdin;
1	passport
2	driving license
\.


--
-- Data for Name: managers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.managers (hotel_id, manager_email) FROM stdin;
1	deadra.krider@gmail.com
2	alonso.tela@gmail.com
3	cathrine.homburg@gmail.com
4	edith.petosa@gmail.com
\.


--
-- Data for Name: supervised; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.supervised (manager_email, employee_email) FROM stdin;
deadra.krider@gmail.com	mckinley.mottai@gmail.com
\.


--
-- Data for Name: user_types; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.user_types (name) FROM stdin;
guest
manager
desk clerk
employee
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (email, name, surname, identification_type, identification_number, user_type, password) FROM stdin;
galymzhan.baltabay@nu.edu.kz	Galymzhan	Baltabay	2	111-123	guest	\N
deadra.krider@gmail.com	Deadra	Krider	1	44112	manager	mypassword
alonso.tela@gmail.com	Alonso	Tela	1	44112	manager	catdog
cathrine.homburg@gmail.com	Cathrine	Homburg	2	441-120	manager	fish
edith.petosa@gmail.com	Edith	Petosa	1	42102	manager	funnybunny
mckinley.mottai@gmail.com	Mckinley	Mottai	1	11490	employee	secret
zakhar.semenov@nu.edu.kz	Zakhar	Semenov	1	11111	guest	123123
\.


--
-- Name: bookings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.bookings_id_seq', 5, true);


--
-- Name: hotels_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hotels_id_seq', 4, true);


--
-- Name: identification_types_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.identification_types_id_seq', 1, false);


--
-- Name: bookings bookings_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT bookings_pkey PRIMARY KEY (id);


--
-- Name: destinations destinations_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.destinations
    ADD CONSTRAINT destinations_pkey PRIMARY KEY (city);


--
-- Name: users guests_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT guests_email_key UNIQUE (email);


--
-- Name: users guests_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT guests_pkey PRIMARY KEY (email);


--
-- Name: hotel_phones hotel_phones_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotel_phones
    ADD CONSTRAINT hotel_phones_pkey PRIMARY KEY (id, phone_number);


--
-- Name: hotel_room_types hotel_room_types_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotel_room_types
    ADD CONSTRAINT hotel_room_types_pkey PRIMARY KEY (id, type);


--
-- Name: hotel_rooms hotel_rooms_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotel_rooms
    ADD CONSTRAINT hotel_rooms_pkey PRIMARY KEY (id, room_number, floor);


--
-- Name: hotels hotels_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotels
    ADD CONSTRAINT hotels_pkey PRIMARY KEY (id);


--
-- Name: identification_types identification_types_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.identification_types
    ADD CONSTRAINT identification_types_pkey PRIMARY KEY (id);


--
-- Name: managers managers_hotel_id_manager_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.managers
    ADD CONSTRAINT managers_hotel_id_manager_email_key UNIQUE (hotel_id, manager_email);


--
-- Name: managers managers_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.managers
    ADD CONSTRAINT managers_pkey PRIMARY KEY (hotel_id);


--
-- Name: bookings no_overlapping_dates; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT no_overlapping_dates EXCLUDE USING gist (hotel_id WITH =, room_number WITH =, floor WITH =, daterange(check_in, check_out, '[]'::text) WITH &&);


--
-- Name: supervised supervised_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supervised
    ADD CONSTRAINT supervised_pkey PRIMARY KEY (manager_email, employee_email);


--
-- Name: hotel_room_types unique_id_type; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotel_room_types
    ADD CONSTRAINT unique_id_type UNIQUE (id, type);


--
-- Name: user_types user_types_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.user_types
    ADD CONSTRAINT user_types_pkey PRIMARY KEY (name);


--
-- Name: bookings bokkings_email_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT bokkings_email_fkey FOREIGN KEY (email) REFERENCES public.users(email);


--
-- Name: bookings bookings_hotel_id_room_number_floor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT bookings_hotel_id_room_number_floor_fkey FOREIGN KEY (hotel_id, room_number, floor) REFERENCES public.hotel_rooms(id, room_number, floor);


--
-- Name: hotels destination_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotels
    ADD CONSTRAINT destination_fkey FOREIGN KEY (destination) REFERENCES public.destinations(city);


--
-- Name: supervised employee_email_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supervised
    ADD CONSTRAINT employee_email_fkey FOREIGN KEY (employee_email) REFERENCES public.users(email);


--
-- Name: hotel_room_types fk_hotel_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotel_room_types
    ADD CONSTRAINT fk_hotel_id FOREIGN KEY (id) REFERENCES public.hotels(id);


--
-- Name: hotel_phones fk_id; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotel_phones
    ADD CONSTRAINT fk_id FOREIGN KEY (id) REFERENCES public.hotels(id);


--
-- Name: users guest_user_type_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT guest_user_type_fkey FOREIGN KEY (user_type) REFERENCES public.user_types(name);


--
-- Name: users guests_identification_type_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT guests_identification_type_fkey FOREIGN KEY (identification_type) REFERENCES public.identification_types(id);


--
-- Name: managers hotel_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.managers
    ADD CONSTRAINT hotel_id_fkey FOREIGN KEY (hotel_id) REFERENCES public.hotels(id);


--
-- Name: managers manager_email_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.managers
    ADD CONSTRAINT manager_email_fkey FOREIGN KEY (manager_email) REFERENCES public.users(email);


--
-- Name: supervised manager_email_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.supervised
    ADD CONSTRAINT manager_email_fkey FOREIGN KEY (manager_email) REFERENCES public.users(email);


--
-- PostgreSQL database dump complete
--

