# Load db

## PostgreSQL shell

    CREATE DATABASE hotel_chain;

## Command Line

    psql -U postgres hotel_chain < hotel_chain.sql

# Data

## Destinations

    ('Almaty'),
    ('Nur-Sultan'),
    ('Shimkent')

## Hotels

    (nextval('hotels_id_seq'), 'Rixos', 'Almaty'),
    (nextval('hotels_id_seq'), 'Elite', 'Nur-Sultan'),
    (nextval('hotels_id_seq'), 'Royal', 'Shimkent'),
    (nextval('hotels_id_seq'), 'Mercure', 'Almaty')

## Hotel phones

    (1, '123-123'),
    (1, '321-321'),
    (2, '333-000'),
    (3, '001-001'),
    (4, '007-666'),
    (4, '123-456')

## Hotel room types

    (1, 'single', 10, 1),
    (1, 'double', 15, 2),
    (1, 'king', 25, 4),
    (2, 'single', 7, 1),
    (2, 'double king', 30, 2),
    (2, 'family', 30, 4),
    (3, 'single', 6, 1),
    (4, 'double', 12, 2)

## Hotel rooms

    (1, 1, 1, 'single', true, false),
    (1, 2, 1, 'single', true, false),
    (1, 3, 1, 'single', true, false),
    (1, 4, 1, 'single', true, false),
    (1, 1, 2, 'double', true, false),
    (1, 2, 2, 'double', true, false),
    (1, 1, 3, 'king', true, false),
    (2, 1, 1, 'single', true, false),
    (2, 2, 1, 'single', true, false),
    (2, 3, 1, 'single', true, false),
    (2, 4, 1, 'single', true, false),
    (2, 1, 2, 'double king', true, false),
    (2, 2, 2, 'double king', true, false),
    (2, 1, 3, 'family', true, false),
    (3, 1, 1, 'single', true, false),
    (3, 2, 1, 'single', true, false),
    (3, 3, 1, 'single', true, false),
    (3, 4, 1, 'single', true, false),
    (4, 1, 1, 'double', true, false),
    (4, 2, 1, 'double', true, false)

## ID types

    (nextval('identification_types_id_seq'), 'passport'),
    (nextval('identification_types_id_seq'), 'driving license')

## Users

    ('zakhar.semenov@nu.edu.kz', 'Zakhar', 'Semenov', 1, '11111', '123123'),
    ('galymzhan.baltabay@nu.edu.kz', 'Galymzhan', 'Baltabay', 2, '111-123', '321321'),
    ('deadra.krider@gmail.com',      'Deadra',    'Krider',   1, '44112',  'manager', 'mypassword'),
    ('alonso.tela@gmail.com',        'Alonso',    'Tela',     1, '44112',  'manager', 'catdog'),
    ('cathrine.homburg@gmail.com',   'Cathrine',  'Homburg',  2, '441-120','manager', 'fish'),
    ('edith.petosa@gmail.com',       'Edith',     'Petosa',   1, '42102',  'manager', 'funnybunny'),
    ('mckinley.mottai@gmail.com',    'Mckinley', 'Mottai',   1, '11490',  'employee', 'secret')

## Bookings

    (nextval('bookings_id_seq'), 'zakhar.semenov@nu.edu.kz', 1, 1, 1, '2021-12-8', '2021-12-10'),
    (nextval('bookings_id_seq'), 'zakhar.semenov@nu.edu.kz', 1, 2, 1, '2021-12-8', '2021-12-10'),
    (nextval('bookings_id_seq'), 'galymzhan.baltabay@nu.edu.kz', 4, 1, 1, '2021-12-8', '2021-12-20')

## Managers

    (1, 'deadra.krider@gmail.com'),
    (2, 'alonso.tela@gmail.com'),
    (3, 'cathrine.homburg@gmail.com'),
    (4, 'edith.petosa@gmail.com')

## Supervised

    ('deadra.krider@gmail.com', 'mckinley.mottai@gmail.com')
