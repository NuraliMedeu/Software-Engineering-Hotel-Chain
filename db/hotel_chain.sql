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
    check_out date
);


ALTER TABLE public.bookings OWNER TO postgres;

--
-- Name: employees; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employees (
    id integer NOT NULL,
    name text,
    surname text
);


ALTER TABLE public.employees OWNER TO postgres;

--
-- Name: guests; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.guests (
    email text,
    name text,
    surname text,
    id integer NOT NULL,
    identification_type integer,
    identification_number text
);


ALTER TABLE public.guests OWNER TO postgres;

--
-- Name: guests_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.guests_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.guests_id_seq OWNER TO postgres;

--
-- Name: guests_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.guests_id_seq OWNED BY public.guests.id;


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
    available boolean
);


ALTER TABLE public.hotel_rooms OWNER TO postgres;

--
-- Name: hotels; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.hotels (
    id integer NOT NULL,
    name text,
    address text
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
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
    email text NOT NULL,
    password text
);


ALTER TABLE public.users OWNER TO postgres;

--
-- Name: guests id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.guests ALTER COLUMN id SET DEFAULT nextval('public.guests_id_seq'::regclass);


--
-- Name: identification_types id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.identification_types ALTER COLUMN id SET DEFAULT nextval('public.identification_types_id_seq'::regclass);


--
-- Data for Name: bookings; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.bookings (id, email, hotel_id, room_number, floor, check_in, check_out) FROM stdin;
\.


--
-- Data for Name: employees; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.employees (id, name, surname) FROM stdin;
\.


--
-- Data for Name: guests; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.guests (email, name, surname, id, identification_type, identification_number) FROM stdin;
\.


--
-- Data for Name: hotel_phones; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hotel_phones (id, phone_number) FROM stdin;
1	123123
1	321321
2	888155
\.


--
-- Data for Name: hotel_room_types; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hotel_room_types (id, type, size, capacity) FROM stdin;
1	single	10	1
1	double	15	2
2	single	7	1
\.


--
-- Data for Name: hotel_rooms; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hotel_rooms (id, room_number, floor, type, available) FROM stdin;
\.


--
-- Data for Name: hotels; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.hotels (id, name, address) FROM stdin;
1	hotel1	almaty
2	hotel2	nur-sultan
\.


--
-- Data for Name: identification_types; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.identification_types (id, name) FROM stdin;
1	passport
2	driving license
\.


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (email, password) FROM stdin;
zakhar.semenov@nu.edu.kz	12345
\.


--
-- Name: guests_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.guests_id_seq', 1, false);


--
-- Name: hotels_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.hotels_id_seq', 2, true);


--
-- Name: identification_types_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.identification_types_id_seq', 1, false);


--
-- Name: bookings bookings_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT bookings_email_key UNIQUE (email);


--
-- Name: bookings bookings_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT bookings_pkey PRIMARY KEY (id);


--
-- Name: employees employees_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employees
    ADD CONSTRAINT employees_pkey PRIMARY KEY (id);


--
-- Name: guests guests_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.guests
    ADD CONSTRAINT guests_email_key UNIQUE (email);


--
-- Name: guests guests_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.guests
    ADD CONSTRAINT guests_pkey PRIMARY KEY (id);


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
-- Name: hotel_room_types unique_id_type; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.hotel_room_types
    ADD CONSTRAINT unique_id_type UNIQUE (id, type);


--
-- Name: users users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT users_pkey PRIMARY KEY (email);


--
-- Name: bookings bookings_hotel_id_room_number_floor_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.bookings
    ADD CONSTRAINT bookings_hotel_id_room_number_floor_fkey FOREIGN KEY (hotel_id, room_number, floor) REFERENCES public.hotel_rooms(id, room_number, floor);


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
-- Name: guests guests_email_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.guests
    ADD CONSTRAINT guests_email_fkey FOREIGN KEY (email) REFERENCES public.users(email);


--
-- Name: guests guests_identification_type_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.guests
    ADD CONSTRAINT guests_identification_type_fkey FOREIGN KEY (identification_type) REFERENCES public.identification_types(id);


--
-- PostgreSQL database dump complete
--

