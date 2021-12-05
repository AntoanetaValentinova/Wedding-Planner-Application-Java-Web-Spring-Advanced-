-- INSERT ROLES -------------------------------------------
INSERT INTO roles (id, name)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, name)
VALUES (2, 'USER');
INSERT INTO roles (id, name)
VALUES (3, 'SUPPLIER');

-- INSERT CATEGORIES -------------------------------------------
INSERT INTO categories (id, name)
VALUES (1, 'VENUES');
INSERT INTO categories (id, name)
VALUES (2, 'PHOTOGRAPHERS');
INSERT INTO categories (id, name)
VALUES (3, 'MUSIC');
INSERT INTO categories (id, name)
VALUES (4, 'CATERING');
INSERT INTO categories (id, name)
VALUES (5, 'FLOWERS');
INSERT INTO categories (id, name)
VALUES (6, 'PLANNING');
INSERT INTO categories (id, name)
VALUES (7, 'DRESSES');
INSERT INTO categories (id, name)
VALUES (8, 'CAKES');
INSERT INTO categories (id, name)
VALUES (9, 'DECOR');
INSERT INTO categories (id, name)
VALUES (10, 'INVITATIONS');
INSERT INTO categories (id, name)
VALUES (11, 'JEWELRY');
INSERT INTO categories (id, name)
VALUES (12, 'TRAVEL');

-- INSERT INITIAL expenses -------------------------------------------
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (1, "Ceremony Venue Fee", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (2, "Ceremony Venue Decorations", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (3, "Reception Venue", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (4, "Rehearsal Dinner Venue", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (5, "Food and Service", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (6, "Beverage and Bartenders", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (7, "Photographer", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (8, "Additional Prints", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (9, "Ceremony Decorations", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (10, "Bouquet", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (11, "Wedding Party Bouquets", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (12, "Wedding Party Boutonnieres", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (13, "Flower Girl Flowers", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (14, "Cake and Cutting Fee", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (15, "Dress and Alterations", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (16, "Groom''s and Groomsmen''s Attire", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (17, "Headpiece and Veil", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (18, "Wedding Accessories", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (19, "Tux or Suit", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (20, "Additional Accessories", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (21, "Band", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (22, "DJ", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (23, "Ceremony Musicians", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (24, "Invitations and Reply Cards", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (25, "Favors and Gifts", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (26, "Officiant", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (27, "Limo or Car Rentals", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (28, "Guest Shuttle or Parking", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (29, "Hair and Makeup", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (30, "Prewedding Pampering", 0, 0, true);
INSERT INTO expenses (id, name, price, paid, initial)
VALUES (31, "Wedding rings", 0, 0, true);


-- INSERT INITIAL TASKS -------------------------------------------
INSERT INTO tasks (id, description, completed, initial)
VALUES (1, "Announce your engagement", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (2, "Plan your engagement party", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (3, "Set a wedding budget", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (4, "Start creating your guest list", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (5, "Find and book your venue", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (6, "Decide on your color scheme", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (7, "Select your wedding party", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (8, "Hire your photographer", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (9, "Schedule an engagement photo shoot", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (10, "Create your wedding website ", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (11, "Hire your caterer", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (12, "Create and send save-the-dates", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (13, "Select an officiant", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (14, "Reserve accommodations for guests", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (15, "Book your wedding night accommodations", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (16, "Find and order your wedding look", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (17, "Book your band", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (18, "Find and hire your DJ", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (19, "Start thinking about your playlist", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (20, "Schedule your fitting appointments", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (21, "Finalize your guest list", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (22, "Hire your florist", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (23, "Update your vendor team", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (24, "Order outfits for your wedding party", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (25, "Hire your baker", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (26, "Hire your ceremony musician", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (27, "Order your wedding invitations", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (28, "Start planning your rehearsal dinner", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (29, "Find and order your event rentals", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (30, "Start planning your honeymoon", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (31, "Research wedding insurance", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (32, "Hire your hair and makeup stylist", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (33, "Add more gifts to your registry", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (34, "Schedule your ceremony rehearsal", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (35, "Order your partner''s attire", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (36, "Order outfits for your ring bearer and flower girl", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (37, "Purchase your wedding accessories", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (38, "Find accessories for your wedding party", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (39, "Purchase your wedding rings", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (40, "Book your wedding transportation", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (41, "Order your wedding favors", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (42, "Get your guest book", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (43, "Send your wedding invitations ", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (44, "Send your rehearsal dinner invites", false, true),
       (45, "Plan your wedding ceremony", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (46, "Time to order alcohol ", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (47, "Order day-of stationery", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (48, "Write your vows", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (49, "Purchase gifts for your wedding party", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (50, "Create wedding day timeline", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (51, "Finalize your vendor team", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (52, "Create your seating chart", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (53, "Assign duties to the wedding party", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (54, "Confirm final details with your vendors", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (55, "Pick up your wedding dress, suit, or tux", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (56, "Write a sweet note to your partner", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (57, "Confirm all final payments", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (58, "Pick up your partner''s attire", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (59, "Pack for your honeymoon", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (60, "Prepare toasts", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (61, "Pull together last-minute essentials", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (62, "Bring decor to your reception venue", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (63, "Review your vendors", false, true);
INSERT INTO tasks (id, description, completed, initial)
VALUES (64, "Send thank-you notes", false, true);
-- INSERT REGIONS AND CITIES -------------------------------------------
INSERT INTO regions(id, name)
VALUES (1, 'South East');
INSERT INTO cities(id, region_id, name)
VALUES (1, 1, 'Runnymede');
INSERT INTO cities(id, region_id, name)
VALUES (2, 1, 'Sussex');
INSERT INTO cities(id, region_id, name)
VALUES (3, 1, 'Winchester');
INSERT INTO cities(id, region_id, name)
VALUES (4, 1, 'Valley');
INSERT INTO cities(id, region_id, name)
VALUES (5, 1, 'Guildford');
INSERT INTO cities(id, region_id, name)
VALUES (6, 1, 'Horsham');
INSERT INTO cities(id, region_id, name)
VALUES (7, 1, 'Fareham');
INSERT INTO cities(id, region_id, name)
VALUES (8, 1, 'Thanet');
INSERT INTO cities(id, region_id, name)
VALUES (9, 1, 'Folkestone and Hythe');
INSERT INTO cities(id, region_id, name)
VALUES (10, 1, 'Ashford');
INSERT INTO cities(id, region_id, name)
VALUES (11, 1, 'Basingstoke and Deane');
INSERT INTO cities(id, region_id, name)
VALUES (12, 1, 'Cherwell');
INSERT INTO cities(id, region_id, name)
VALUES (13, 1, 'Buckinghamshire');

INSERT INTO regions(id, name)
VALUES (2, 'South West');
INSERT INTO cities(id, region_id, name)
VALUES (14, 2, 'South Somerset');
INSERT INTO cities(id, region_id, name)
VALUES (15, 2, 'Devon');
INSERT INTO cities(id, region_id, name)
VALUES (16, 2, 'Gloucester');
INSERT INTO cities(id, region_id, name)
VALUES (17, 2, 'Swindon');
INSERT INTO cities(id, region_id, name)
VALUES (18, 2, 'Torridge');
INSERT INTO cities(id, region_id, name)
VALUES (19, 2, 'Teignbridge');
INSERT INTO cities(id, region_id, name)
VALUES (20, 2, 'Dorset');
INSERT INTO cities(id, region_id, name)
VALUES (21, 2, 'Cotswold');
INSERT INTO cities(id, region_id, name)
VALUES (22, 2, 'Sedgemoor');
INSERT INTO cities(id, region_id, name)
VALUES (23, 2, 'Somerset West and Taunton');
INSERT INTO cities(id, region_id, name)
VALUES (24, 2, 'South Hams');
INSERT INTO cities(id, region_id, name)
VALUES (25, 2, 'Tewkesbury');
INSERT INTO cities(id, region_id, name)
VALUES (26, 2, 'Mendip');
INSERT INTO cities(id, region_id, name)
VALUES (27, 2, 'Exeter');
INSERT INTO cities(id, region_id, name)
VALUES (28, 2, 'Cheltenham');
INSERT INTO cities(id, region_id, name)
VALUES (29, 2, 'Bournemouth');
INSERT INTO cities(id, region_id, name)
VALUES (30, 2, 'Mid Devon');
INSERT INTO cities(id, region_id, name)
VALUES (31, 2, 'Stroud');
INSERT INTO cities(id, region_id, name)
VALUES (32, 2, 'Bristol');

INSERT INTO regions(id, name)
VALUES (3, 'West Midlands');
INSERT INTO cities(id, region_id, name)
VALUES (33, 3, 'Malvern Hills');
INSERT INTO cities(id, region_id, name)
VALUES (34, 3, 'Wychavon');
INSERT INTO cities(id, region_id, name)
VALUES (35, 3, 'Redditch');
INSERT INTO cities(id, region_id, name)
VALUES (36, 3, 'Herefordshire');
INSERT INTO cities(id, region_id, name)
VALUES (37, 3, 'Warwick');
INSERT INTO cities(id, region_id, name)
VALUES (38, 3, 'Shropshire');
INSERT INTO cities(id, region_id, name)
VALUES (39, 3, 'City of Stoke-on-Trent');
INSERT INTO cities(id, region_id, name)
VALUES (40, 3, 'Stratford-on-Avon');
INSERT INTO cities(id, region_id, name)
VALUES (41, 3, 'Birmingham');
INSERT INTO cities(id, region_id, name)
VALUES (42, 3, 'Newcastle-under-Lyme ');

INSERT INTO regions(id, name)
VALUES (4, 'Eastern');
INSERT INTO cities(id, region_id, name)
VALUES (43, 4, 'Colchester');
INSERT INTO cities(id, region_id, name)
VALUES (44, 4, 'Epping Forest');
INSERT INTO cities(id, region_id, name)
VALUES (45, 4, 'Three Rivers');
INSERT INTO cities(id, region_id, name)
VALUES (46, 4, 'Huntingdonshire');
INSERT INTO cities(id, region_id, name)
VALUES (47, 4, 'South Cambridgeshire');
INSERT INTO cities(id, region_id, name)
VALUES (48, 4, 'Broadland');
INSERT INTO cities(id, region_id, name)
VALUES (49, 4, 'Babergh');
INSERT INTO cities(id, region_id, name)
VALUES (50, 4, 'Dacorum');
INSERT INTO cities(id, region_id, name)
VALUES (51, 4, 'City of Peterborough');
INSERT INTO cities(id, region_id, name)
VALUES (52, 4, 'Tendring');
INSERT INTO cities(id, region_id, name)
VALUES (53, 4, 'Mid Suffolk');
INSERT INTO cities(id, region_id, name)
VALUES (54, 4, 'South Norfolk');
INSERT INTO cities(id, region_id, name)
VALUES (55, 4, 'Hertsmere');
INSERT INTO cities(id, region_id, name)
VALUES (56, 4, 'Central Bedfordshire');

INSERT INTO regions(id, name)
VALUES (5, 'North East');
INSERT INTO cities(id, region_id, name)
VALUES (57, 5, 'Northumberland');
INSERT INTO cities(id, region_id, name)
VALUES (58, 5, 'Middlesbrough');
INSERT INTO cities(id, region_id, name)
VALUES (59, 5, 'Stockton-on-Tees');
INSERT INTO cities(id, region_id, name)
VALUES (60, 5, 'Sunderland');
INSERT INTO cities(id, region_id, name)
VALUES (61, 5, 'Darlington');
INSERT INTO cities(id, region_id, name)
VALUES (62, 5, 'Durham');
INSERT INTO cities(id, region_id, name)
VALUES (63, 5, 'Gateshead');

INSERT INTO regions(id, name)
VALUES (6, 'Wales');
INSERT INTO cities(id, region_id, name)
VALUES (64, 6, 'Powys');
INSERT INTO cities(id, region_id, name)
VALUES (65, 6, 'Ceredigion / Sir Ceredigion');
INSERT INTO cities(id, region_id, name)
VALUES (66, 6, 'Rhondda Cynon Taf');
INSERT INTO cities(id, region_id, name)
VALUES (67, 6, 'Gwynedd');
INSERT INTO cities(id, region_id, name)
VALUES (68, 6, 'Neath Port Talbot');
INSERT INTO cities(id, region_id, name)
VALUES (69, 6, 'Caerphilly');
INSERT INTO cities(id, region_id, name)
VALUES (70, 6, 'Blaenau Gwent');
INSERT INTO cities(id, region_id, name)
VALUES (71, 6, 'Merthyr Tydfil');

INSERT INTO regions(id, name)
VALUES (7, 'London');
INSERT INTO cities(id, region_id, name)
VALUES (72, 7, 'Ealing');
INSERT INTO cities(id, region_id, name)
VALUES (73, 7, 'London');
INSERT INTO cities(id, region_id, name)
VALUES (74, 7, 'Croydon');
INSERT INTO cities(id, region_id, name)
VALUES (75, 7, 'Bexley');
INSERT INTO cities(id, region_id, name)
VALUES (76, 7, 'Redbridge');
INSERT INTO cities(id, region_id, name)
VALUES (77, 7, 'Westminster');
INSERT INTO cities(id, region_id, name)
VALUES (78, 7, 'Haringey');
INSERT INTO cities(id, region_id, name)
VALUES (79, 7, 'Bromley');
INSERT INTO cities(id, region_id, name)
VALUES (80, 7, 'Islington');
INSERT INTO cities(id, region_id, name)
VALUES (81, 7, 'Barnet');
INSERT INTO cities(id, region_id, name)
VALUES (82, 7, 'Enfield');

INSERT INTO regions(id, name)
VALUES (8, 'North West');
INSERT INTO cities(id, region_id, name)
VALUES (83, 8, 'Lancaster');
INSERT INTO cities(id, region_id, name)
VALUES (84, 8, 'Allerdale');
INSERT INTO cities(id, region_id, name)
VALUES (85, 8, 'Chorley');
INSERT INTO cities(id, region_id, name)
VALUES (86, 8, 'Barrow-in-Furness');
INSERT INTO cities(id, region_id, name)
VALUES (87, 8, 'Wigan');
INSERT INTO cities(id, region_id, name)
VALUES (88, 8, 'Hyndburn');
INSERT INTO cities(id, region_id, name)
VALUES (89, 8, 'South Lakeland');
INSERT INTO cities(id, region_id, name)
VALUES (90, 8, 'Oldham');
INSERT INTO cities(id, region_id, name)
VALUES (91, 8, 'Rossendale');
INSERT INTO cities(id, region_id, name)
VALUES (92, 8, 'Preston');
INSERT INTO cities(id, region_id, name)
VALUES (93, 8, 'Stockport');
INSERT INTO cities(id, region_id, name)
VALUES (94, 8, 'Bury');

INSERT INTO regions(id, name)
VALUES (9, 'East Midlands');
INSERT INTO cities(id, region_id, name)
VALUES (95, 9, 'West Northamptonshire');
INSERT INTO cities(id, region_id, name)
VALUES (96, 9, 'Melton');
INSERT INTO cities(id, region_id, name)
VALUES (97, 9, 'Derbyshire Dales');
INSERT INTO cities(id, region_id, name)
VALUES (98, 9, 'West Northamptonshire');
INSERT INTO cities(id, region_id, name)
VALUES (99, 9, 'East Lindsey ');
INSERT INTO cities(id, region_id, name)
VALUES (100, 9, 'Amber Valley');
INSERT INTO cities(id, region_id, name)
VALUES (101, 9, 'Leicestershire');
INSERT INTO cities(id, region_id, name)
VALUES (102, 9, 'Rushcliffe');

-- INSERT ADDRESSES -------------------------------------------
INSERT INTO addresses(id, address, city_id)
VALUES (1, 'High Street 15', 1),             -- PHOTOGRAPHER
       (2, 'Station Road 165', 2),  -- VENUE
       (3, 'Main Street 13', 2),      -- DJ
       (4, 'Park Road 67', 2),          -- FLOWERS
       (5, 'Church Road', 1),     -- CAKES
       (16, 'Church Street 15', 10),          -- PHOTOGRAPHER
       (17, 'London Road 165', 36),   -- VENUE
       (18, 'Victoria Road 13', 26),   -- DJ
       (19, 'Green Lane 67', 6),           -- FLOWERS
       (20, 'Manor Road 29', 16),     -- CAKES
       (31, 'Church Lane 15', 15), -- PHOTOGRAPHER
       (32, 'Park Avenue 165', 83),        -- VENUE
       (33, 'The Avenue 13', 77),     -- DJ
       (34, 'The Crescent 67', 54),       -- FLOWERS
       (35, 'Queens Road 29', 58),             -- CAKES

       (44, 'New Road 15', 17),             -- PHOTOGRAPHER
       (45, 'Grange Road 165', 15),          -- VENUE
       (46, 'Kingsway 13', 33),               -- DJ
       (47, 'Kings Road 67', 42),    -- FLOWERS
       (48, 'Windsor Road 53', 42),           -- CAKES

       (59, 'Highfield Road 15', 13),                -- PHOTOGRAPHER
       (60, 'Mill Lane 165', 19),    -- VENUE
       (61, 'Alexander Road 13', 20),              -- DJ
       (62, 'York Road 67', 30),       -- FLOWERS
       (63, 'St. John’s Road 53', 31),              -- CAKES

       (74, 'Main Road 15', 45),              -- PHOTOGRAPHER
       (75, 'Broadway 165', 66),              -- VENUE
       (76, 'King Street 13', 77),            -- DJ
       (77, 'The Green 67', 55),         -- FLOWERS
       (78, 'Springfield Road 53', 56),            -- CAKES

       (89, 'George Street 15', 73),               -- PHOTOGRAPHER
       (90, 'Park Lane 165', 3),               -- VENUE
       (91, 'Victoria Street 13', 23),             -- DJ
       (92, 'Albert Road 67', 24),          -- FLOWERS
       (93, 'Queensway 53', 70),             -- CAKES

       (104, 'New Street 15', 51),           -- PHOTOGRAPHER
       (105, 'Queen Street 165', 56),           -- VENUE
       (106, 'West Street 13', 77),         -- DJ
       (107, 'North Street 67', 46),          -- FLOWERS
       (108, 'Manchester Road 53', 39),                -- CAKES

       (119, 'The Grove 15', 4),            -- PHOTOGRAPHER
       (120, 'Richmond Road 165', 44),        -- VENUE
       (121, 'Grove Road 13', 55),            -- DJ
       (122, 'South Street 67', 67),           -- FLOWERS
       (123, 'School Lane 53', 78),                -- CAKES

       (134, 'The Drive 15', 12),             -- PHOTOGRAPHER
       (135, 'North Road 165', 23),     -- VENUE
       (136, 'Stanley Road 13', 76),             -- DJ
       (137, 'Chester Road 67', 43),    -- FLOWERS
       (138, 'Mill Road', 32);         -- CAKES
      ;

-- INSERT SUPPLIERS WITH OFFERS ---------------------------------------------------------------------------
-- PHOTOGRAPHERS
INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (1, '2021-10-12', 'ashley@shley.com',
        '35153ca0c770699421f5986b6acb62399525eaad681bce59e03f0ea41a5c42b506db831ceb2dfdf5',
        'Ashley Craddock Ltd.', '+42365474799', 1);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (1, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (1,
        'Hi! I''m Ashley I am the Lead photographer and owner of Ashley Craddock Photography. I operate out of Winston Salem, North Carolina. I strive to provide couples with exceptional service and visually stunning photographic keepsakes on their wedding day. Photography is my passion so i am 100% dedicated to honoring your one-of-a-kind love story throughout my work, I hope to give you a fun personal experience that will create memories that you love to look back on.',
        'To ensure that your wedding day is documented just as you envisioned, Ashley Craddock Photography offers clients a wide range of services. Engagement photo shoots are available, affording couples the opportunity to get to know their photographer prior to their wedding day. Packages can include up to twelve hours of coverage on the big day, as well as the services of a second photographer. Destination packages are available, allowing Ashley to capture your joyous day wherever your heart desires.',
        50, 1500, 2000, '+7618401284', 'Ashley Craddock Photography', 1, 2,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (1, '2nd Shooter'),
       (1, 'Add''l Hours'),
       (1, 'Engagement Shoot'),
       (1, 'High-Res Images'),
       (1, 'Multi. Locations'),
       (1, 'One Event / Day'),
       (1, 'Digital Files'),
       (1, 'Save the Date');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (3,'Ashley Craddock Photography','bride-1874655_1920_ld4fve','https://res.cloudinary.com/dj5akxhq1/image/upload/v1638139611/bride-1874655_1920_ld4fve.jpg',1),
    (2,'Ashley Craddock Photography','couple-gc8f54b283_1280_xiwmha','https://res.cloudinary.com/dj5akxhq1/image/upload/v1638139610/couple-gc8f54b283_1280_xiwmha.jpg',1),
    (1,'Ashley Craddock Photography','bride-gaad7d1301_1280_jqxvzf','https://res.cloudinary.com/dj5akxhq1/image/upload/v1638139610/bride-gaad7d1301_1280_jqxvzf.jpg',1);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (52,
        'Hi! I''m Ashley I am the Lead photographer and owner of Ashley Craddock Photography.Providing an upscale and fun-filled experience, this company offers an interactive way for guests to create personalized mementos for the event. Their photo booths feature an incredible range of capabilities, from boomerangs and GIFs to social media sharing.',
        'offers a customized experience for newlyweds-to-be on their special day. You can avail of a customized ring light, background screen, and overlay to make photos stand out and complement your event aesthetic. A range of backdrops is available, along with photo filters to add an extra layer of fun. Guests will be able to take home a copy of their picture, which can also be sent directly to their phones or shared via social media. These high-tech photo booths can also create GIFs, videos, and boomerangs for a live-action capture of guests enjoying your day.',
        50, 2000, 3000, '+7618401284', 'Ashley Craddock', 1, 2,'DECLINED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (52, 'Backdrop(s)'),
       (52, 'Prints'),
       (52, 'Props'),
       (52, 'Social Media Integration');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (131,'Ashley Craddock Videographer','wedding-2448396_1920_q200px','https://res.cloudinary.com/dj5akxhq1/image/upload/v1638148340/wedding-2448396_1920_q200px.jpg',52),
    (132,'Ashley Craddock Videographer','wedding-2954545_1920_bia2ej','https://res.cloudinary.com/dj5akxhq1/image/upload/v1638148340/wedding-2954545_1920_bia2ej.jpg',52);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status,created)
VALUES (53,
        'Hi! I''m Ashley I am the Lead photographer and owner of Ashley Craddock Photography. Videographer Julius Ferrer specializes in wedding videography, capturing your full day in it all of its glory. He provides modern, cinematic documentation of your wedding day using a contemporary and photojournalistic style to capture footage. His wedding videography packages range in services and price in order to best fit your wedding style, preferences and budget. First & Last Productions also offers additional services, including wedding photography, family portraiture, and more.',
        'On the big day, the videography team will use wireless microphones and multiple camera angles to showcase the beautiful details of your event. From pre-ceremony preparations to the last dance of the evening, the team can be there to capture it all. When the festivities draw to a close, you and your partner can relive the special day via a high-quality recording of the live stream. This way, you can enjoy the momentous occasion for years to come.',
        50, 2000, 3000, '+7618401284', 'Ashley Craddock Videographer', 1, 2,'PENDING','2021-12-05');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (53, 'High-Def Video'),
       (53, 'Multi. Cameras'),
       (53, 'Raw Footage'),
       (53, 'Save The Date');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (129,'Ashley Craddock Videographer','woman-984244_1920_mi3wam','https://res.cloudinary.com/dj5akxhq1/image/upload/v1638147900/woman-984244_1920_mi3wam.jpg',53),
    (130,'Ashley Craddock Videographer','woman-4081760_1920_bytoqp','https://res.cloudinary.com/dj5akxhq1/image/upload/v1638147900/woman-4081760_1920_bytoqp.jpg',53);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (2, '2021-10-13', 'kelly@kelly.com',
        '4629285726bf42998979522a4d9072f65a1cfd56e4c45e1e718cea84360d6b52336d1249f5f8462c',
        'Kelly Knaub Ltd.', '+2345867', 16);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (2, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (2,
        'Kelly Knaub Photography is a wedding photographer based in York, Pennsylvania. Owner Kelly is eager to document special days throughout central Pennsylvania, Maryland, and beyond. This dedicated professional is honored to be chosen to preserve to-be-newlyweds’ precious moments and joyous occasions.',
        'Kelly finds meaning in helping happy couples make lasting memories on their big day. She enjoys getting to know soon-to-be spouses so that she can provide a personal and comfortable photography experience. With her traditional and natural style, she is able to capture every romantic candid and composed moment throughout the celebration. By committing to one event per day, Kelly can give each couple the special attention to detail they deserve. This creative artist is happy to arrange engagement sessions, boudoir photoshoots, wedding portrait sessions, destination wedding photoshoots, and trash-the-dress sessions. Kelly Knaub Photography can provide the final images in prints or digital files, on canvas, or in an album.',
        30, 1400, 1800, '+9638900-085', 'Kelly Knaub Photography', 2, 2,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (2, 'Add''l Hours'),
       (2, 'Engagement Shoot'),
       (2, 'High-Res Images'),
       (2, 'Multi. Locations'),
       (2, 'One Event / Day'),
       (2, 'Toning'),
       (2, 'Albums'),
       (2, 'Digital Files');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (4,'Kelly Knaub Photography','wedding-1770860_1920_duiojo','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636899030/wedding-1770860_1920_duiojo.jpg',2),
    (5,'Kelly Knaub Photography','wedding-1850074_1920_fadfbn','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636899030/wedding-1850074_1920_fadfbn.jpg',2),
    (6,'Kelly Knaub Photography','wedding-1361076_1920_a8ougk','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636899029/wedding-1361076_1920_a8ougk.jpg',2);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (3, '2021-10-13', 'riany@riany.com',
        'b1298377810a10c652dfaeba5e0b27ccf15984217be0d01b3710167eaf73d6c41285265b1a196151',
        'Riany Haffey', '+3245678654321', 31);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (3, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (3,
        'Riany Haffey Photography is a wedding photography company based in Framingham, Massachusetts. Owner Riany believes that great photography isn’t just about capturing beautiful images. A great wedding photographer also wants her couples to have an enjoyable experience. Riany is dedicated to helping you look and feel your best. Riany hopes that your day will be filled with wonderful moments that you will remember and cherish forever, and she can’t wait to help you tell your story.',
        'Riany Haffey Photography covers weddings in New England and beyond. Riany is also available for engagement, portraits, and trash-the-dress sessions. Wedding package features and options include a pre-wedding consultation, a second photographer, up to eight hours of event coverage, and an online gallery of high-resolution images. Whatever your needs, Riany is determined to help you turn your wedding dreams into reality.',
        100, 1800, 2500, '+234567890', 'Riany Haffey Photography', 3, 2,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (3, '2nd Shooter'),
       (3, 'Engagement Shoot'),
       (3, 'High-Res Images'),
       (3, 'Multi. Locations'),
       (3, 'One Event / Day'),
       (3, 'Digital Files');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (7,'Riany Haffey Photography','wedding-1353829_1920_yydfof','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636899029/wedding-1353829_1920_yydfof.jpg',3),
    (8,'Riany Haffey Photography','wedding-1594957_1920_otdezm','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636899029/wedding-1594957_1920_otdezm.jpg',3),
    (9,'Riany Haffey Photography','wedding-1017239_1920_vvbcnd','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636899028/wedding-1017239_1920_vvbcnd.jpg',3);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (4, '2020-10-13', 'strain@strain.com',
        '5679210281da3c4a39a31cacce400b9a98e3092f0b20a1c7037a40c2a9cc6cdc67672cd6a6167086',
        'Strain Ltd.', '+21412985035', 44);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (4, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (4,
        'The Adirondacks is the home to Photography by Strain, a business that specializes in the capture and curation of precious wedding photo galleries. Owner, Nichole Strain is an easy-going individual who is head-over-heels about love and all-things nuptial. This expert strives to create a relaxed working environment where her clients feel comfortable in front of the camera. She maintains that by doing this, she encourages couples to be more natural while she snaps away at the magic as it unfolds.',
        'Your stress-free experience is valued above all else when you work alongside Photography by Strain. Through a variety of customizable wedding packages, Nichole aims to help you get the most out of your investment. You can look forward to more than just beautiful high-resolution digital photographs as this expert offers a range of physical keepsakes too. This includes wedding albums, canvases, and various prints of your special moments.',
        150, 2000, 2800, '+2345678', 'Photography by Strain', 4, 2,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (4, 'Add''l Hours'),
       (4, 'Engagement Shoot'),
       (4, 'High-Res Images'),
       (4, 'One Event / Day'),
       (4, 'Digital Files'),
       (4, 'Multi. Locations');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (10,'The Adirondacks','wedding-628515_1920_uadmdw','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636899028/wedding-628515_1920_uadmdw.jpg',4),
    (11,'The Adirondacks','wedding-1034430_1920_oazopj','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636899027/wedding-1034430_1920_oazopj.jpg',4);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (5, '2021-10-13', 'brittny@brittny@com',
        '51e82ac16e986c4a13264c9cd1ea804da7b7efa18c3474a37526ee781a20a4e41c8cb03e10589e54',
        'Brittny Ltd.', '+23456787547', 59);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (5, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (5, 'Hello! Brittny Hart here! I am a full-time boudoir and destination wedding photographer.',
        'Brittny is a people person who enjoys working with couples on their special day. He loves being part of the process from the engagement to the ceremony and through to the big party. His wedding packages begin with six hours of coverage, one photographer, and digital files with a print release. Couples can also customize their packages to their needs and desires. Negley Stockman Photography specializes in capturing carefree and romantic moments, and strives to bring out the personalities of his clients in every shot.',
        100, 1200, 1600, '+231242356', 'Brittny Photography', 5, 2,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (5, 'Engagement Shoot'),
       (5, 'High-Res Images'),
       (5, 'Digital Files'),
       (5, 'Save the Date');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (12,'Brittny Hart','wedding-609105_1920_luo2ea','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636899028/wedding-609105_1920_luo2ea.jpg',5),
    (13,'Brittny Hart','wedding-1183271_1920_ee0fes','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636899027/wedding-1183271_1920_ee0fes.jpg',5),
    (14,'Brittny Hart','wedding-626020_1920_odqdnq','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636899027/wedding-626020_1920_odqdnq.jpg',5);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (6, '2021-10-13', 'joshua@joshua.com',
        'e61f0d982b6270042e24e977f48b3682cd73be9e0da20e371b459900c73034b3a68a699bb8a5fe32',
        'Joshua J Krause Ltd.', '+1523523646', 74);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (6, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (6,
        'Joshua J Krause Photography, based in Vancouver, Washington, offers couples a unique and passionate documentary photography experience for their special day. Focusing on candid moments, this artist adores capturing the joy and sincerity of each client he works with.',
        'Joshua J Krause Photography offers a range of packages, all of which are customizable to suit your needs. He is happy to consult with you before the big day to help him learn how he can best preserve your wedding celebration. Primarily serving the Portland/Vancouver area, Joshua is also open to traveling throughout the Greater Northwest Area and beyond.',
        150, 2600, 3000, '+32525723750', 'Joshua J Krause Photography', 6, 2,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (6, 'Engagement Shoot'),
       (6, 'High-Res Images'),
       (6, 'Multi. Locations'),
       (6, 'Slideshow'),
       (6, 'Albums'),
       (6, 'Digital Files');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (15,'Joshua J Krause Photography','wedding-725432_1280_hoiw9y','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636899026/wedding-725432_1280_hoiw9y.jpg',6),
    (16,'Joshua J Krause Photography','wedding-756269_1920_ztprtj','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636899026/wedding-756269_1920_ztprtj.jpg',6),
    (17,'Joshua J Krause Photography','wedding-437969_1920_w5mxkr','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636899026/wedding-437969_1920_w5mxkr.jpg',6);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (7, '2020-10-13', 'emily@emily.com',
        '8c3e989cb3b1920d5b233bce203cb3f1fe34ced89cc3ce1ea424b799f9fb27c22a4270291d5a8a56',
        'Emily Diane Ltd.', '+5476809089', 89);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (7, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (7,
        'Emily Diane Photography offers collections tailored to the happy couple’s needs. Whether the wedding is on the expansive shores of Lake Superior or in a banquet hall, Emily is happy to lend her expertise. She is also open to travel and discussing destination packages. Couples can inquire for specialty portrait sessions like engagement, couples, and day-after shoots. Owner and sole photographer, Emily Wiitanen is a woman of faith and uses her business as her ministry to serve couples and establish relationships that''ll carry on past the wedding day. Inheriting her passion from her father, this expert has always felt at home behind the lens of a camera. Today, she is the proud owner of her very own business and has curated an impressive portfolio of work. Her style can be described as traditional yet takes a natural approach to diversify her galleries.',
        'For a more streamlined process, Emily Diane Photography offers three mindfully designed wedding collections for you to consider. Emily has tailored these packages to make sure your investment matches your needs and requirements. Some post-wedding keepsake items can be arranged directly through Emily Diane Photography. These items include custom wedding albums, canvases, matted and regular prints.',
        200, 3000, 3600, '+767643435768', 'Emily Diane Photography', 7, 2,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (7, 'Add''l Hours'),
       (7, 'Engagement Shoot'),
       (7, 'High-Res Images'),
       (7, 'Multi. Locations'),
       (7, 'One Event / Day'),
       (7, 'Digital Files'),
       (7, 'Prints');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (18,'Emily Diane Photography','sunset-3191131_bamxzb','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636898978/sunset-3191131_bamxzb.jpg',7),
    (19,'Emily Diane Photography','sunset-g83ee746d6_1920_hoy3ac','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636898980/sunset-g83ee746d6_1920_hoy3ac.jpg',7),
    (20,'Emily Diane Photography','ring-1167514_1920_d9oaqt','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636898976/ring-1167514_1920_d9oaqt.jpg',7);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (8, '2021-10-13', 'gade@gade.com',
        'ad0ed1c58c843d4b3b42f378745d25fb35e352d6aff45c4853fdc41328b4de296cd5c7780baac72a',
        'Gadé Laví Ltd.', '+23456789', 104);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (8, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (8,
        'Gadé Laví is a wedding photography business owned and operated by Lenisha Harry. Passionate about documenting weddings, Leni loves becoming a fly on the wall and capturing every laugh and tender moment. After more than four years of photography experience, Leni continues to bring boundless enthusiasm and attention to detail to each photo session. Her style of photography is a combination of contemporary and traditional compositions with an emphasis on natural light and candid imagery.',
        'Gadé Leví offers three detailed photography packages for weddings, ranging from engagement sessions to intimate elopements and lavish affairs. All three packages include an online gallery of professionally edited photos and a print release. Additional services such as custom wedding invitations, photo albums, and a second photographer are available in the premium package.',
        300, 2000, 2500, '+5348172649128', 'Gadé Laví', 8, 2,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (8, 'Add''l Hours'),
       (8, 'Engagement Shoot'),
       (8, 'High-Res Images'),
       (8, 'Albums'),
       (8, 'Digital Files'),
       (8, 'Proofs'),
       (8, 'Save the Date');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (21,'Gadé Laví','sports-1482019_1920_mwnwut','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636898977/sports-1482019_1920_mwnwut.jpg',8),
    (22,'Gadé Laví','newlyweds-458119_1920_oaqbvz','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636898976/newlyweds-458119_1920_oaqbvz.jpg',8),
    (23,'Gadé Laví','people-2566244_1920_kbbta4','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636898975/people-2566244_1920_kbbta4.jpg',8);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (9, '2021-10-13', 'katie@katie.com',
        '25336fa35e1d1afea9c22bce2b9d0bfc6c0eab5a24f67a0fb30cdc8d0cd2afbf29358562397c7ad5',
        'Katie Hoff Ltd.', '+21649187503', 119);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (9, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (9,
        'Katie Hoff Photography is a wedding and lifestyle photography company based in Oklahoma but also shoots wedding in surrounding states. Owner and operator Katie Hoff is a talented storyteller who strives to create timeless photographic keepsakes her clients can cherish for years to come. With a contemporary and natural approach, she documents the carefully posed and designed scenes of the day as well as candid moments of laughter and love.',
        'To ensure a fully tailored service to every couple, Katie Hoff Photography provides a wide range of offerings. Along with coverage on the day of your event, Katie offers engagement and boudoir photo shoots. The services of a second photographer can be provided on your wedding day, providing assurance that every important detail will be captured. Your finished photographs can be made available to you in the form of high-resolution digital files and prints.',
        500, 3000, 4000, '+547343233', 'Katie Hoff Photography', 9, 2,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (9, '2nd Shooter'),
       (9, 'Add''l Hours'),
       (9, 'Engagement Shoot'),
       (9, 'High-Res Images'),
       (9, 'Multi. Locations'),
       (9, 'One Event / Day'),
       (9, 'Digital Files');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (24,'Katie Hoff Photography','marriage-918864_1920_d0wle6','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636898975/marriage-918864_1920_d0wle6.jpg',9),
    (25,'Katie Hoff Photography','lace-768476_1920_azb7oh','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636898975/lace-768476_1920_azb7oh.jpg',9),
    (26,'Katie Hoff Photography','marriage-636018_oc6qwf','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636898974/marriage-636018_oc6qwf.jpg',9);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (10, '2021-10-13', 'kepler@kepler.com',
        '066ce8f8ae61b9afa97c303fba0a9ee27c3d0aba89a7c3715a43b5eb75ed23cf2ce5123d5475e87f',
        'Ty Kepler', '+3653765', 134);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (10, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (10,
        'Ty Kepler Photography is a wedding photography company based in Clearfield, Pennsylvania. Owner Ty has loved photography for as long as he can remember, and that passion has continued to deepen and develop with the years. He is inspired by the beautiful places he has seen and the many wonderful people he has met along the way. Ty wants to preserve the joy and beauty of your special day in a collection that you can keep and cherish forever.',
        'Ty Kepler Photography is ready to document your day’s precious moments. Ty offers a range of wedding packages designed to suit a variety of needs and budgets. Every package includes color correction, an online gallery, high-resolution images with print release, and one year of backup and file storage. Ty’s premium package also includes an engagement session, full-day coverage, and a large print. Hardcover photo books are also available for purchase.',
        100, 1200, 2000, '+3561356', 'Ty Kepler Photography', 10, 2,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (10, 'Additional Hours'),
       (10, 'Custom Graphics'),
       (10, 'Destination / Travel'),
       (10, 'Engagement Shoot'),
       (10, 'High-Res Images'),
       (10, 'Multi. Locations'),
       (10, 'One Event / Day'),
       (10, 'Wedding Portraits');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (27,'Ty Kepler Photography','love-g30f6311f1_1920_phexlh','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636898974/love-g30f6311f1_1920_phexlh.jpg',10),
    (28,'Ty Kepler Photography','i-love-3122498_1920_wivyqm','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636898974/i-love-3122498_1920_wivyqm.jpg',10),
    (29,'Ty Kepler Photography','couple-gc8f54b283_1280_tje7on','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636898973/couple-gc8f54b283_1280_tje7on.jpg',10);
-- VENUES
INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (11, '2021-10-13', 'heavenly@heavenly.com',
        '988851ac5aa473c5df868c8b868d35107cc96199897f769f743205d7523b14ecf19a32b2c638818c',
        'Alaska Heavenly Lodge Ltd.', '345678', 2);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (11, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (11,
        'Alaska Heavenly Lodge is a beautiful wedding venue located in Cooper Landing, Alaska. With surrounding mountains, lovely flowers, manicured lawns, and majestic views, the venue offers plentiful picture-perfect spots. The venue creates a peaceful, natural setting for all wedding-related events.',
        'With various wedding packages, Alaska Heavenly Lodge is a full-service venue. It offers taylored insight and guidance while planning, accommodations, bridal suite, set up, and clean up. Its packages can be customized to fit the individual needs of couples.

Accommodations
The venue can accommodate up to 25 overnight guests in its three log cabins: the Main Lodge, Mt. Cecil Cabin, and the Russian River Cabin. The cabins feature comfortable guest rooms with Alaskan rustic furniture, BBQ grills, picnic tables, large viewing decks, and other recreational amenities such as the hot tub and sauna in the Russian River Cabin.',
        null, 4600, 7700, '+23456789098', 'Alaska Heavenly Lodge', 11, 1,'APPROVED');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (30,'Alaska Heavenly Lodge','wedding-6569411_1920_cg87xn','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907819/wedding-6569411_1920_cg87xn.jpg',11),
    (31,'Alaska Heavenly Lodge','wedding-5432446_1920_ilgl5r','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907817/wedding-5432446_1920_ilgl5r.jpg',11),
    (32,'Alaska Heavenly Lodge','wedding-reception-1284245_1920_mbbo3a','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907817/wedding-reception-1284245_1920_mbbo3a.jpg',11);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (12, '2021-10-13', 'cascata@cascata.com',
        '8528c637eef20d66d14e47ec8bed0aa553c20b388d9177a08a96268d35adf7ac335f751e51eb9912',
        'Cascata Springs Ltd.', '+21423645756', 17);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (12, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (12,
        'Cascata Springs is a wedding venue that is located in Lewisburg, Tennessee. This villa takes inspiration from the Italian countryside and is nestled in the picturesque and serene midlands of Tennessee. Guests will have a stunning panorama of a 3-acre lake that flanks the main building, creating a tranquil atmosphere that is ideal for relaxation. Adding to that, there is a sunset lanai where visitors are able to lounge and forget their worries as they enjoy the views. Couples will find many areas that display beautifully throughout the property. Some of these include flower gardens, springs, bridges, various ceremony sites, and a waterfall. Combined with Cascata Springs all-inclusive services, hosts are sure to be pleased with their location selection.',
        'Facilities and Capacity

This property is gorgeously decorated and is well suited to elegantly rustic occasions. The sunset lanai is an open-air space that provides shelter as well as outstanding photo opportunities. Both ceremonies and receptions can take place here. Couples and their guests will have access to an on-site bar stage, and two distinct bathrooms. There are also charming elements such as chandeliers, string lights, and archways. The grounds present a fairy tale getaway for nuptials or exploration. There are plenty of intriguing discoveries throughout the grassy landscape. Get-ready rooms are provided, and there is also a hilltop lodge for couples wishing to stay overnight. The cabin-inspired accommodation is inclusive of 3,700 square feet.

Services Offered

Cascata Springs offers their clients a range of services to help their wedding function go forward flawlessly. Some of these packages include line items such as rehearsal time allotments, a selection of four ceremony site locations, decor pieces, dining facilities, and more. The Cascata Springs team is able to coordinate vendor bookings such as an officiant, a DJ, catering, a photographer, among others. Additional rentals and services are available as well. Bookings may take place on either Saturday or Sunday, in coordination with the dedicated package for that day. Should couples be interested in learning more about how this property can accommodate their wedding plans, they may reach out to this venue directly.',
        null, 3000, 4000, '+12345678', 'Cascata Springs', 12, 1,'APPROVED');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (33,'Cascata Springs','venue-1754494_1920_dwarrc','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907817/venue-1754494_1920_dwarrc.jpg',12),
    (34,'Cascata Springs','wedding-table-1174135_1920_wbyblp','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907817/wedding-table-1174135_1920_wbyblp.jpg',12),
    (35,'Cascata Springs','wedding-reception-1284245_1920_mbbo3a','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907817/wedding-reception-1284245_1920_mbbo3a.jpg',12);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (13, '2021-10-13', 'banquet@banquet.com',
        'c1987dc5be84cd6fe19c8ce0a5f5187ef2de005905a1e779d1365386b0b7e4fd3d3df098a8d45f3e',
        'Upland Events and Banquet Center Ltd.', '+1232423', 32);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (13, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (13,
        'Upland Events and Banquet Center is a modern wedding venue located in the heart of Upland, California. Couples can host their ceremony, cocktail hour, and reception in the elegant, indoor ballroom. This fun, modern space is conveniently situated between Los Angeles, Riverside, and the Orange County area, making it easily accessible for your out-of-town guests. The team at this facility works hard to bring every couple''s vision to life, giving them a day they''ll never forget.',
        'Facilities and Capacity
        Couples can host up to 250 guests at their Upland Events and Banquet Center wedding. Whether they prefer modern minimalism or a more classic, romantic style, the site''s experienced team is on hand to help bring their ideas to life. Their large banquet hall features high ceilings dotted with grand chandeliers, elegant white draping, an elevated stage and DJ booth, and plenty of space for a dance floor. Once the ceremony is over, the newlyweds and their guests can retire to the adjoining foyer for cocktails from the built-in bar. The team can then rearrange the hall to suit your reception. There is also a gorgeous outdoor patio that couples and guests can avail of for some fresh air. The catering company can take advantage of the on-site prep kitchen to put the final touches on their dishes. Before the day begins, the to-be-weds and their party can finish their preparations in the stylish get-ready suite.
        Services Offered
        The team at Upland Events and Banquet Center prides themselves on their friendly support and affordable packages, helping every couple to have a memorable celebration. Their goal is to ensure you have a relaxed and stress-free planning experience, so you can truly enjoy your day. Tables, Chiavari chairs, and linens are included in the rental fee, giving the to-be-weds fewer things to organize. The venue also supplies china, flatware, and glassware for receptions. Setup and cleanup is offered by the on-site team, allowing you to sit back, relax, and enjoy your celebration.',
        null, 5000, 6000, '+33276523765', 'Upland Events and Banquet Center', 13, 1,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (13, 'Bridal Suite'),
       (13, 'Chairs'),
       (13, 'China'),
       (13, 'Clean Up'),
       (13, 'Event Planning'),
       (13, 'Lighting/Sound'),
       (13, 'Linens'),
       (13, 'Parking'),
       (13, 'Set Up'),
       (13, 'Tables'),
       (13, 'Transportation');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (36,'Upland Events and Banquet Center','table-4736377_1920_cqqfjb','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907816/table-4736377_1920_cqqfjb.jpg',13),
    (37,'Upland Events and Banquet Center','table-3018151_1920_rkvszg','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907816/table-3018151_1920_rkvszg.jpg',13),
    (38,'Upland Events and Banquet Center','tablecloth-3336687_1920_xkdnvp','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907816/tablecloth-3336687_1920_xkdnvp.jpg',13);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (14, '2021-10-13', 'cedar@cedar.com',
        '1373e2975cdb011992a301de14d3f8e7a6e866f3dd05ca62560f05e290d284e69eee0ae43b7929da',
        'The Cedar House Ltd.', '+3456789', 45);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (14, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (14,
        'This establishment was built over the course of seven years by one family. Each detail, from the shining epoxy floors to the warming stone fireplace, was designed with to-be-weds in mind, resulting in a romantic ambience for special moments. This family is truly honored to welcome couples into their venue to let it become the setting for their milestone occasions.',
        'Facilities and Capacity
        The Cedar House at Rollin Rock Ranch offers several event spaces filled with rustic charm where couples can share their big days with loved ones. Open-air ceremonies can be held in the garden where couples can say "I do" under an antique metal arch. Loved ones can look on from bench seating while the strings of lighting throughout the trees create a romantic atmosphere. Alternatively, ceremonies can also take place inside in the venue''s greatroom. From here, newlyweds can celebrate in the main banquet hall with up to 160 guests. Depending on each couple''s preferences, the interior can be adorned with beautiful flower arrangements, rose garland table decor, and signs with sweet messages. For parties of 200 or more, celebrations can be extended to the outdoor area. On the patio shaded by an oak tree, newlyweds and their guests will be able to admire the venue''s beautiful grounds.
        Services Offered
        The event staff at The Cedar House at Rollin Rock Ranch is dedicated to creating unforgettable celebrations for newlyweds and their loved ones. For seamless dining experiences, the building features a kitchen equipped with two gas ovens, four sinks, a private wine bar, and more. Here, each couple''s preferred catering team can create stand-out dishes. Prior to the ceremony, to-be-weds are welcome to prepare in either of the on-site get-ready rooms. Each is complete with a full bathroom and bedroom, creating a relaxing environment where lifelong memories with loved ones can be made. After the festivities draw to a close, up to 14 people can rest in the venue''s lodge.',
        null, 4000, 5000, '+234567898765', 'The Cedar House', 14, 1,'APPROVED');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (39,'The Cedar House','118863613_651514481929541_1219585352337673612_o_wm2rvs','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907809/118863613_651514481929541_1219585352337673612_o_wm2rvs.jpg',14),
    (40,'The Cedar House','2_1168_bq3zev','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907809/2_1168_bq3zev.jpg',14),
    (41,'The Cedar House','20210506_133222_Medium_btrkjs','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907808/20210506_133222_Medium_btrkjs.jpg',14);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (15, '2021-10-13', 'oldtown@oldtown.com',
        '1900402ef51bc692bb9a797f4bedfc56654c3b3ce0198eca182c0066b8611ffa8008e5164295b0be',
        'An Old Town Ltd.', '+0908767543', 60);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (15, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (15,
        'An Old Town Wedding and Event Center is a banquet hall wedding venue . This venue is great for couples who are looking for a wedding venue that offers the charm of a beautiful garden party.',
        'Facilities and Capacity
An Old Town Wedding and Event Center provides both covered and uncovered outdoor event spaces for you to host your wedding ceremony and reception. This 1940’s red-brick house sits on over one-half acre of lush gardens with beautiful fountains. The property has many different colors of seasonal flowers, green plants, spacious grass areas, and large mature trees which create the most picture-perfect setting for wedding photos! This outdoor wedding venue can accommodate up to 275 people. Couples can get married in the elevated, white gazebo and then take photos by the covered patio with an eight-foot decorated arch that is great for photos.
Services Offered
An Old Town Wedding and Event Center offers three different tiers of all-inclusive wedding and reception packages so each couple can select one that best meets their desires and needs. Each package varies in the amenities and services offered, but each one includes ceremony and reception services.
The Simply Stated Package gives couples seven hours in the venue along with an on-site coordinator, event rentals, get-ready rooms, decorations, DJ, photographer, wedding flowers, and catering services. The Wedding Delight Package includes everything from the Simply Stated Package in addition to an officiant, table toppers, coffee, lemonade fountain, and more. The Celebration Package includes everything from the other two packages in addition to a margarita machine, china, guest tables, head tables, drink refill, and more.',
        null, 2000, 3000, '+09878654', 'An Old Town Wedding and Event Center', 15, 1,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (15, 'Private tour'),
       (15, 'On-site coordinator'),
       (15, 'Event rentals'),
       (15, 'Guest book stand'),
       (15, 'Picture table'),
       (15, 'Gift table'),
       (15, 'Unity ceremony table'),
       (15, 'Get-ready room'),
       (15, 'DJ'),
       (15, 'Photographer'),
       (15, 'Wedding flowers'),
       (15, 'Photo booth');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (42,'An Old Town Wedding and Event Center','20210515_192123_0_Medium_p8nflv','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907808/20210515_192123_0_Medium_p8nflv.jpg',15),
    (43,'An Old Town Wedding and Event Center','12_Medium_ptgzut','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907807/12_Medium_ptgzut.jpg',15);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (16, '2021-10-13', 'aston@aston.com',
        '2dd221dffde4e7f026c692b05afaeae42b39534d6689dd6d5fd712ea331b77749465790b0ef742dc',
        'Aston Ltd.', '+0987654', 75);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (16, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (16,
        'This space welcomes up to 300 wedding guests for a couple’s big day. Couples and their wedding party can take photos around the property of the Aston Oaks Banquet Center, which includes marvels such as stoic trees and a wooden bridge with rustic metal railings. This bridge sits high enough to provide naturally framed photos of the couple or wedding party. The venue’s open and spacious Oak Room banquet hall room features square white columns and bronze light fixtures overhead. Large windows overlook the venue’s property.',
        'Cuisine
Bar service for four hours with a fully stocked bar is included when couples celebrate their wedding at this venue. A champagne toast for the entire wedding party is also included. The staff also offers complete wedding cake cutting service.
Other Services
Couples can also host their bridal showers and engagement parties at this venue. Gazebo and patio rentals adjacent to the Oak Room are available for the couple as well.',
        null, 500, 600, '+98765455678', 'Aston', 16, 1,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (16, 'Centerpieces'),
       (16, 'Chairs'),
       (16, 'Cleanup'),
       (16, 'Decor'),
       (16, 'Event planning'),
       (16, 'Event rentals'),
       (16, 'Liability insurance'),
       (16, 'Parking'),
       (16, 'Setup'),
       (16, 'Tables');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (44,'Aston','3_Millennium_Ballroom_Wedding_axfnk7','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907809/3_Millennium_Ballroom_Wedding_axfnk7.jpg',16),
    (45,'Aston','events-2609305_1920_befnno','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907813/events-2609305_1920_befnno.jpg',16);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (17, '2021-10-13', 'stoney@stoney.com',
        '79b7321fb022295232bd210d0f823db6f90c7cb23effa7903f8f13c21d543315d0abff565dbc365d',
        'Stoney Creek Ltd.', '+234567634', 90);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (17, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (17,
        'At The Stoney Creek Hotel & Conference Center couples planning their nuptials can rent this space as a luxurious wedding venue.  This city venue allows couples an elegant retreat for their wedding, while still remaining steps away from restaurants, art centers, and other entertainment.',
        'Facility and Capacity
The ballroom and banquet hall event spaces at the conference center allow both intimate and large wedding parties. Their spaces are ideal for small groups of 50 people, or big celebratory groups of up to 425 guests for wedding ceremonies, receptions, bridal showers, engagement parties, or rehearsal dinners.
Services Offered
Knowing the most important part of this time is for a couple to enjoy being in love while planning their wedding, The Stoney Creek Hotel & Conference Center strives to assist in any way possible with the design process. They employ experienced wedding planning professionals who can provide as much attention as is necessary to create such a special day. In addition to a bridal suite, the hotel can also supply chairs, lighting/sound, centerpieces, and a beautiful dance floor. The in-house catering team is ready to add your unique tastes to their menu, from hors d’oeuvres at the cocktail reception to a buffet or plated serving style at the reception. The hotel also allows couples to use their inventory of barware, flatware, linens, china, and glassware. The licensed in-house bar can provide experienced bartenders after the ceremony, capable of maintaining an open bar, limited bar, or cash bar. Couples can choose to enjoy:',
        null, 1400, 3000, '+12345677', 'Stoney Creek Hotel & Conference', 17, 1,'APPROVED');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (46,'The Stoney Creek Hotel & Conference Center','2_Millennium_Ballroom_Wedding_nma1oz','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907811/2_Millennium_Ballroom_Wedding_nma1oz.jpg',17),
    (47,'The Stoney Creek Hotel & Conference Center','1_Millennium_Ballroom_Wedding_vsaxyi','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907810/1_Millennium_Ballroom_Wedding_vsaxyi.jpg',17),
    (48,'The Stoney Creek Hotel & Conference Center','champagne-3954774_1920_o4q0bc','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907812/champagne-3954774_1920_o4q0bc.jpg',17);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (18, '2021-10-13', 'utopia@com',
        '06e40bf5bc210b72f62ac496da72c513699b5665c0e7035037b2f75bd03ec5157eb54e018b1ca2d7',
        'Utopia Ltd.', '+098765', 105);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (18, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (18,
        'Congratulations and thank you for your interest in Utopia River Retreat for your special day.Whether it be along the banks of the cypress tree lined Sabinal River, on one of our lawns under magnificent centuries-old live oak trees or in the fully enclosed elegant rustic barn with an attached deck and gazebo, the property offers numerous opportunities to host your ceremony and reception.',
        'Accommodations
Oral History indicates that the land Utopia now occupies was originally settled in the 1860’s, then known as the Bownds Fort Site. Serving as the centerpiece of our accommodations and event space, the now fully renovated Fortress was originally a stone barn. This was constructed as a Fort with gun-ports as a defense against Native American incursions into the valley. Today the Fortress has two master suites and 3 semi-private loft areas making it perfect for larger groups or families.
The Fortress is flanked by nine additional one and two-bedroom cabins sleeping up to 4 to 6 people each and offering splendid views of the surrouding river valley, making this a truly all-inclusive event space for your momentous weekend. In addition to our on-site accommodations we also have additional managed properties in the area available for your guests.',
        null, 3000, 5000, '+7865456789', 'Utopia', 18, 1,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (18, 'Private access to the river throughout the property'),
       (18, 'Free Wi-Fi throughout the property'),
       (18, 'Gated pool area with adjoining covered gazebo');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (49,'Utopia River Retreat','119592736_3686640354699498_8004894136734784105_o_ibvhcv','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907811/119592736_3686640354699498_8004894136734784105_o_ibvhcv.jpg',18),
    (50,'Utopia River Retreat','119468897_3686640641366136_7868827374689588073_o_luylph','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907810/119468897_3686640641366136_7868827374689588073_o_luylph.jpg',18),
    (51,'Utopia River Retreat','118616642_645664792514510_1922611558387896719_o_ulvm57','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907811/118616642_645664792514510_1922611558387896719_o_ulvm57.jpg',18);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (19, '2021-10-13', 'parker@parker.com',
        'f46ebd97822827c87a126cf821da4e00a4e2b394827f1a14ddc71d89da0b618aca6090cb52366c24',
        'Parker Garage', '+987654345', 120);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (19, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (19,
        'Since 2014, this restaurant has been providing couples and their loved ones a warm, welcoming place to dine and dance. From private rehearsal dinners to larger celebrations, the onsite team will be ready to turn your reception into a fun, flavorsome night.',
        'Facilities and Capacity
Parker Garage offers three separate spaces to host your nuptial events. For intimate gatherings with your wedding party, the Chef''s Table makes for a memorable celebration. Up to eight guests will gather around the wooden tabletop beside an extensive wine display, and enjoy a multi-course dinner made by the team''s executive chef. For larger events, the private dining room can seat up to 45 guests. The large windows, contemporary hardwood floors, and neutral color scheme act as a blank canvas for soon-to-be-weds to design their dream day. The team can also organize a private buyout for guests to have private access to the entire restaurant during their celebration. Up to 200 attendees can be comfortably seated among the historical, industrial-chic setting.
Services Offered
The in-house event director works closely with soon-to-be-weds, to ensure each element matches their unique vision. Executive Chef Logan Mason customizes each menu during private events, to give each guest a refined dining experience.',
        null, 3000, 4000, '+987656434456789', 'Parker Garage', 19, 1,'APPROVED');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (52,'Parker Garage','mykonos-5854670_1920_pyn94v','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907814/mykonos-5854670_1920_pyn94v.jpg',19),
    (53,'Parker Garage','exclusive-banquet-1812772_1920_s7rjqh','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907814/exclusive-banquet-1812772_1920_s7rjqh.jpg',19);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (20, '2021-10-13', 'plant@plant.com',
        '5676164d1f660aa5013c4279c4d9792180592220917f559f9fce82a4258ba95be7bc2f0c93701fbb',
        'SteamPlant Event Center', '+23456788976543', 135);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (20, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (20,
        'This newly renovated steam power plant, first constructed in 1887, retains much of its historical charm. The combination of original architectural features, exposed brick, and chic decor effortlessly creates a romantic ambiance for your long-anticipated wedding celebration. On the banks of the Arkansas River, this venue offers couples a peaceful and natural oasis in an urban setting to host the event of their dreams.',
        'Facilities and Capacity
Couples are welcome to share their love and joy with their loved ones at The SteamPlant Event Center on their wedding day. You will be invited to begin your day in the comfort of the venue’s get-ready suites, preparing in luxury and style. Your loved ones will be met by the chic cobblestone plaza at the front of the property, an ideal location for a memorable outdoor ceremony. Indoors, the elegant refurbished ballroom offers a versatile space for your service or celebration. With high ceilings, exposed brick, and hardwood flooring, this space is a versatile setting that can be fully customized to suit your every requirement. Couples are welcome to make use of a range of event items, including an arch, chairs, and tables. The plaza offers a warm, sunny location for an elegant cocktail hour. The on-site theatre, art galleries, and convention space are available to couples looking for an alternative gathering place.
Services Offered
The dedicated team at SteamPlant Event Center will work diligently to ensure that your wedding day is executed seamlessly. Couples are welcome to host a number of other events at the venue, including engagement parties, wedding showers, rehearsal dinners, and elopements. The venue’s professional wedding planner will be on hand to guide you through the planning process, ensuring couples a stress-free experience. The team provides set up and clean up services, allowing couples to fully relax and enjoy their celebration without worrying about the smaller details. Professional and friendly bartenders will serve signature drinks and specialty beers, liquors, and wines from an open or cash bar.',
        null, 3000, 6000, '+9878674567', 'SteamPlant Event Center', 20, 1,'APPROVED');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (54,'SteamPlant Event Center','events-2609526_1920_l5xpgi','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907815/events-2609526_1920_l5xpgi.jpg',20),
    (55,'SteamPlant Event Center','table-3018151_1920_rkvszg','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636907816/table-3018151_1920_rkvszg.jpg',20);

-- MUSIC AND DJS
INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (21, '2021-10-14', 'thebears@thebears.com',
        '7e67b22fea3918a2b696c9eeee3cb823b974d5752448fda3eeade9629fa74e930908011c7ced29f7',
        'The Bears Ltd.', '+5768098097', 3);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (21, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (21, 'The Bears are proud to be celebrating 10 years in business. That''s almost 2,000 gigs played 200+ thousand miles travelled 500+ venues rocked 200+ thousand people entertained Millions of notes (beautifully) plucked We''d LOVE to soundtrack your wedding
Aww, look at you two! Congratulations on your engagement! Can we come to the wedding?
Hello, We''re The Bears! We love to play Pop/Rock classic party anthems from the 60''s to the 10''s....tensies!?
With a huge repertoire of over 200 songs we''ll light up any room you put us in! In fact we''re so confident we''ll offer you our ''We''ll get your *nan dancing or your money back'' guarantee!
*nan must be relatively mobile to start off with. I mean we''re good but not THAT good...',
        'We''re self-contained - great sound system, stage lights, disco lights, smoke machine etc..
We can play our exhaustive party playlist for in-between sets or you can make your own and we''ll turn it up!...although go easy on the obscure Nirvana b-sides though yeah!?
You''ll be in safe hands, like all these good people were - BBC, T Mobile, GM, London Boat Show, Excel London, Royal Air Force, British Army, The Dorchester, Savoy, Hatfield House...and most likely the place you''re getting hitched at!',
        2000, 2000, 2500, '+232456789', 'The Bears Band', 21, 3,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (21, 'Can we request specific pieces/songs'),
       (21, 'Do you travel'),
       (21, 'Is your equipment PAT tested (if applicable)'),
       (21, 'Can you perform outside'),
       (21, 'Do you have Public Liability Insurance'),
       (21, 'Lighting');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (56,'The Bears Band','audience-1853662_1920_b1tulc','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636926582/audience-1853662_1920_b1tulc.jpg',21),
    (57,'The Bears Band','audience-1850665_1920_rl2vxa','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636926581/audience-1850665_1920_rl2vxa.jpg',21);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (22, '2021-10-14', 'spectrum@spectrum.abv',
        '44b0ff743a4cdccdcffcb5e6a6223bcaf10caa67c83ee0c7e43949da02cf5e474c2fdfc4cb29db30',
        'The Spectrum Ltd.', '+32456789', 18);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (22, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (22, 'The Spectrum will rock your wedding. Only playing the best songs from the last 50 years.',
        'The Spectrum have been playing for weddings for the past 6 years with a growing reputation as the only choice to rock your party!
With excellent feedback and client recommendations you can be confident booking this professional band that come complete with a dj & sound engineer at every wedding.',
        1000, 2000, 3000, '+23456789', 'The Spectrum Band', 22, 3,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (22, ' Can we request specific pieces/songs'),
       (22, ' Do you require food or drink'),
       (22, 'Do you have Public Liability Insurance'),
       (22, 'Can you perform outside'),
       (22, 'Do you travel'),
       (22, 'Is your equipment PAT tested (if applicable)'),
       (22, 'DJ Booth Hire, PA System Hire, Lighting');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (58,'The Spectrum Band','guitar-756326_1920_xz7vrz','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636926580/guitar-756326_1920_xz7vrz.jpg',22);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (23, '2021-10-14', 'fortune@fortune.com',
        '01dec172a0ede1a38c16c604d578138c3f16116a9ea0251e4d75b3f18c403fcb60eab467bf266774',
        'Fortune', '+23456789', 33);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (23, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (23,
        'FORTUNE are an award winning London based wedding band with a repertoire spanning 5 decades from classic soul, Motown, pop, rock, hip-hop, garage and current chart hits. Choose your perfect band from 5 - 11 performers guaranteed to dazzle any wedding size and style.',
        'This slick 5-11 piece band is composed of London’s hottest session musicians and also offer DJs, dancers, lighting, sound & all other event production. Their award winning after dinner party sets are perfect for weddings and are catered around each individual couple''s music taste. Fortune also offer musical options for ceremony, cocktail reception, dinner and after-party including traditional classical elements to innovate modern DJ Live and everything in-between.

From their roots at The Royal Academy of Music, all members balance performing at exclusive events alongside collectively working with some of the biggest names in the UK Top 40 & The West End. Fortune''s reputation among the Europe''s leading wedding planners & venues ensures a busy calendar packed full of amazing events.
Come join the Fortune party!',
        2000, 1500, 10000, '+3456789', 'Fortune Ltd.', 23, 3,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (23, 'Can we request specific pieces/songs'),
       (23, 'Do you require food or drink'),
       (23, 'Do you have Public Liability Insurance'),
       (23, 'Can you perform outside'),
       (23, 'Do you travel'),
       (23, 'Is your equipment PAT tested (if applicable)'),
       (23,
        'Soloist, Group, Band, DJ, Caricaturist, Children''s, Bollywood musicians, Dancers, String quartet, Harpist, Guitarist, Organist, Steel band, Swing band, Jazz band, Tribute band, Party Band, Sound&Lighting, Other'),
       (23, 'Dancefloor Hire, DJ Booth Hire, PA System Hire, Lighting, Other');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (59,'Fortune','wedding-1403282_1920_ckouyw','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636926581/wedding-1403282_1920_ckouyw.jpg',23),
    (60,'Fortune Ltd.','piano-3703616_1920_a4oycw','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636926583/piano-3703616_1920_a4oycw.jpg',23);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (24, '2021-10-14', 'hothats@hothats.com',
        '45547af4b486a3c9553adcdb8906657826d91d26d813af34e9c943272db1ee2e0e146d5ea9889714',
        'Hot Hats Ltd.', '+345678', 46);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (24, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (24, 'Acoustic wedding party band playing hit songs from the 60s- 00s.

The Hot Hats are one of the leading wedding bands in the south west. With over 4 hours of live music and a free tailored DJ service, a unique up-tempo sound of a full band, these wedding guitarists can be relied on to fill any dance-floor.',
        'Making sure you get everything you want for your special day the Hot Hats will work closely with you on the lead up to your event and ensure you get all your favourite songs played. They can also provide a chilled acoustic wedding duo style set perfect to greet the arrival of your guests, or afternoon drinks reception.

Playing hit songs from the 60s – 00s these two charismatic characters can unobtrusively socialise with your guests between sets, and with their compact set-up are suitable for an intimate wedding or large reception hall with a full sound that’s clear as a bell and conjure up an infectious beat to get you moving.

Please review our testimonials, take a look at our live videos and listen to our music. Put the icing on the cake with this top acoustic south west wedding band the Hot Hats!',
        500, 5000, 6000, '+23456789', 'Hot Hats', 24, 3,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (24, 'Can you perform outside'),
       (24, 'Do you travel'),
       (24, 'Is your equipment PAT tested (if applicable)'),
       (24, 'Do you require food or drink'),
       (24, 'Do you have Public Liability Insurance'),
       (24, 'Soloist, Group, Band, Guitarist, Party Band, Sound&Lighting');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (61,'Hot Hats','michaelwill-8311_odqhwb','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636927149/michaelwill-8311_odqhwb.jpg',24),
    (62,'Hot Hats','concert-1854113_1920_ghwpwe','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636926581/concert-1854113_1920_ghwpwe.jpg',24);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (25, '2021-10-14', 'funk@funk.com',
        'b4864ce72b079759eff4f5eb3013ca37a8f66aea1f1993f25050be65716dd6e1948939c70033422a',
        'Funk City Band', '+234567898978', 61);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (25, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (25,
        '*Special discounts for July 18* Funk City play fun, upbeat and classic songs in a way that everyone will enjoy. You want to have fun and you want to dance for the whole time. We know this too! If you want a fantastic party that''s fun and memorable...try us.',
        'Funk City have played over 470 wedding and 8.5k other shows. There aren''t many bands that have the experience we have. Also we are all married ourselves so we know exactly what you''re going through and how important it is to get it right first time. We genuinely want you to have the best day of your life and will help facilitate that in every way possible.
We play upbeat songs that everyone will love and the set list is normally chosen by the bride and groom to make it more personal. We include a free DJ for the time we are not playing live. We want you to DANCE LIKE CRAZY for the whole time.
There is a a duo and trio for smaller parties and up to 5-7 for bigger events. We can tailor our set and size to any audience. You will have the best time and WE WILL, WE WILL ROCK YOU.',
        1700, 3000, 7000, '+2345678989767', 'Funk City Band', 25, 3,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (25, 'Can we request specific pieces/songs'),
       (25, 'Do you travel'),
       (25, 'Is your equipment PAT tested (if applicable)'),
       (25, 'Can you perform outside'),
       (25, 'Do you have Public Liability Insurance'),
       (25, 'Group, Band, Jazz band, Party Band'),
       (25, 'Dancefloor Hire, PA System Hire, Lighting');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (63,'Funk City Band','Rock-and-Pop-Function-Bands_uoj2n9','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636927148/Rock-and-Pop-Function-Bands_uoj2n9.jpg',25),
    (64,'Funk City Band','23_mixtape_weddingcrashers_296-e1391428118413_mv91co','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636927148/23_mixtape_weddingcrashers_296-e1391428118413_mv91co.jpg',25);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (26, '2021-10-14', 'halo@halo.com',
        '3ddbb672a3b58db7fefe92ef83960d5579bcd46bb68382108bc095d8a9605bdd4db41b4257b71e48',
        'Halo Strings Ltd.', '+34679876547', 76);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (26, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (26, 'Halo Strings, an experienced and versatile acoustic and electric female string ensemble that can provide tailored performances at any event in any location.
Halo Strings is your luxury and professional string ensemble.',
        'Virtuoso and talented musicians with a number of accolades and awards to their name.
Halo Strings have been putting on unforgettable performances. We offer a versatile selection of performances that can be tailored exactly to your needs.
We provide flexibility in size of group from 1 to 10+ players! solo, string duo, trio, quartet, sextet, octet and beyond.
We offer a show that is the ultimate in impressive entertainment. We can take any event to a new and astounding level.
Halo Strings also do explosive and elegant performances with LED instruments. These performances will add a unique touch.
We have experience performing at luxury events, weddings, corporate events, launches and private parties.
Halo Strings, a luxury touch for your event.',
        1000, 500, 1000, '+236687779', 'Halo Strings', 26, 3,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (26, 'Can we request specific pieces/songs'),
       (26, 'Do you require food or drink'),
       (26, 'Do you have Public Liability Insurance'),
       (26, 'Can you perform outside'),
       (26, 'Do you travel'),
       (26, 'Is your equipment PAT tested (if applicable)'),
       (26, 'Soloist, Group, DJ, Bollywood musicians, String quartet, Harpist');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (65,'Halo Strings','sea-3847921_1920_hirdvq','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636926584/sea-3847921_1920_hirdvq.jpg',26),
    (66,'Halo Strings','orchestra-2496505_1920_njliud','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636926584/orchestra-2496505_1920_njliud.jpg',26);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (27, '2021-10-14', 'musicants@musicants.com',
        '0021af336f47b1c78348996d1ebf05cf4a2068e46dcbe6aaf764ad35ce104ad7d8332d9fe7365db7',
        'Musicians Inc.', '+465454654', 91);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (27, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (27,
        'Musicians Inc is an exclusive music and entertainment agency specialising in curating entertainment for weddings. Musicians Inc look after some of the most talented musicians , performing with everyone from the Royal Philharmonic Orchestra to pop stars such as Olly Murs!',
        'Musicians Inc has been providing music and entertainment for Weddings and events for more than 15 years. Performers are selected for our books through audition process, chosen for their professionalism, skill and showmanship. All of our performers have been trained to the highest standards at Europe’s leading Music Conservatoires and Performing Arts Schools . By selecting the finest talent available for our agency, you can book with confidence, knowing you are getting the best.

Our agents are highly experienced and know what makes an event run smoothly. By listening carefully to the clients needs Musicians Inc is able to curate music and entertainment to perfectly suit your vision. We pride ourselves on being able to offer clients acts with an edge bringing your event to life with unique entertainment.',
        5000, 5000, 7000, '+8755434356', 'Musicants Inc.', 27, 3,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (27, 'Can we request specific pieces/songs'),
       (27, 'Do you require food or drink'),
       (27, 'Do you have Public Liability Insurance'),
       (27, 'Can you perform outside'),
       (27, 'Do you travel'),
       (27,
        'Soloist, Group, Band, DJ, Children''s, Bollywood musicians, String quartet, Harpist, Guitarist, Steel band, Swing band, Jazz band, Ceilidh Band, Tribute band, Party Band, Sound&Lighting, Other');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (67,'Musicants Inc','music-3264716_1920_mtijix','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636926583/music-3264716_1920_mtijix.jpg',27),
    (68,'Musicants Inc','performance-3202707_1920_hfpljw','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636926583/performance-3202707_1920_hfpljw.jpg',27);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (28, '2021-10-14', 'warble@warble.com',
        '71dc6e1dc93d9aa39fb8101d4fa51060ebd1ea93159c4d4de565269b674b3921ad2f9eda2d1b4cc0',
        'Warble Entertainment Ltd.', '+63472365475694', 106);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (28, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (28, 'Warble Entertainment are leading wedding entertainment agency. You can book your live wedding band, caricaturist, magician, fire performer, harpist and acoustic musicians at Warble with ease.
When you get your wedding entertainment right, it can absolutely make your wedding day.',
        'At Warble Entertainment, we understand how important wedding entertainment is. We also understand that it isn''t something people book every day!
Booking a live band or a musician is made fun and easy with us. This will be one of the most exciting things you book for your wedding, and rightly so.
Music can elevate a room and shift the mood entirely. We''re proud to have the best wedding bands in the UK exclusive to us, you won''t find anyone better.
Warble Entertainment also specialise in all kinds of unique and alternative entertainment including magicians, caricaturists, celebrity lookalikes, singing waiters and glow performers.
We have a 24 hour emergency helpline and are with you every step of the way to making sure your wedding day runs smoothly with our entertainment.',
        2000, 5000, 10000, '+534763254237654', 'Warble Entertainment', 28, 3,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (28, 'Can we request specific pieces/songs'),
       (28, 'Do you require food or drink'),
       (28, 'Do you have Public Liability Insurance'),
       (28, 'Can you perform outside'),
       (28, 'Do you travel'),
       (28,
        'Soloist, Group, Band, DJ, Magician, Caricaturist, Comedian, Children''s, Bollywood musicians, Dancers, String quartet, Harpist, Guitarist, Organist, Steel band, Swing band, Jazz band, Ceilidh Band, Tribute band, Party Band, Other');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (69,'Warble Entertainment','unnamed_kqxqso','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636927148/unnamed_kqxqso.jpg',28),
    (70,'Warble Entertainment','band-4671748_1920_b4z3z4','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636926581/band-4671748_1920_b4z3z4.jpg',28);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (29, '2021-10-14', 'johngreen@john.com',
        'f026a6b38161a38e4433e9bcd6b5ce4d2b7c1b09c4277a7ab8913687a36ff2a06b096a0c66838212',
        'John Green Dynamic Entertainments Ltd.', '+35672356238', 121);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (29, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (29, 'John Green Dynamic Entertainments (JGDE) is based in St Austell, Cornwall, offering the very best in music & lighting.
Using my unique music & custom lighting packages, I make your ideas come to life.',
        'Weddings are my speciality, no matter how large or intimate, I have the experience to make any size wedding reception a bespoke occasion. Customised planning forms make event planning easy. Special preferences for mood lighting the venue in your wedding colours are carefully discussed. Requested music is handled well in advance of your wedding to ensure perfection on your special day. Using the combined experience & knowledge of 2500+ events over the last 18 years I will make your special day one to remember, from the first consultation to the last dance. I will deliver your music, announcements & any other formalities with precision & care. Everyone is different. What you would love, another couple may loath. For me, it''s all about giving each couple exactly what they desire for the biggest day of their lives & that’s what I deliver every time. The new rustic setup is proving to be a popular addition to my services for all barn and rustic weddings. Please take a look at all the other examples of my work along with reviews on my website.',
        1200, 4000, 6000, '+3732752845524', 'John Green Dynamic Entertainments', 29, 3,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (29, 'Can we request specific pieces/songs'),
       (29, 'Do you require food or drink'),
       (29, 'Do you have Public Liability Insurance'),
       (29, 'Can you perform outside'),
       (29, 'Do you travel'),
       (29, 'DJ, Sound&Lighting'),
       (29, 'DJ Booth Hire, PA System Hire, Lighting');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (71,'John Green Dynamic Entertainments','dj-1531431_1920_obmzzp','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636926584/dj-1531431_1920_obmzzp.jpg',29),
    (72,'John Green Dynamic Entertainments','live-music-2219036_1920_kwmrbb','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636926582/live-music-2219036_1920_kwmrbb.jpg',29);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (30, '2021-10-14', 'firstdance@firstdance.com',
        'f7448e07fc1b94e8fdc8213b1aa580f454a12e2cd086e1375e743cbe162175906b980d0a1015662a',
        'Save The First Dance Ltd', '+342374685668', 136);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (30, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (30, 'Save The First Dance Ltd offer Bespoke Luxury Dance Services & Entertainment.

Save The First Dance Ltd offer a range of luxury bespoke Dance Services & Live Acts/Event Entertainment Worldwide.',
        'When it comes to making a wow factor event, you simply can’t leave anything up to chance. Thats where Save The First Dance Ltd arrive. Save The First Dance Ltd has experience in providing an array of entertainment for both large and small events, and they plan everything they do down to the smallest detail. With their performers coming straight off the West End stage, number one touring show & other international high profile jobs, Save The First Dance Ltd deliver that high end quality of services possible that will make your event the topic of conversation. They’ll stake our reputation on it.',
        10000, 10000, 20000, '+34723562465', 'Save The First Dance', 30, 3,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (30, 'Can we request specific pieces/songs'),
       (30, 'First Dance Lessons'),
       (30, 'Do you have Public Liability Insurance'),
       (30, 'Can you perform outside'),
       (30, 'Do you travel'),
       (30, 'Do you do bespoke packages'),
       (30, 'Bride & Groom Party Flash Mob Dance'),
       (30, 'Singing & Dancing Waiters/Waitresses'),
       (30, 'Live Acts & Event Entertainment'),
       (30, 'Bespoke Entertainment Performances');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (73,'Save The First Dance','live-music-for-a-wedding_a8kz5b','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928027/live-music-for-a-wedding_a8kz5b.jpg',30),
    (74,'Save The First Dance','unnamed_ifcagx','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928027/unnamed_ifcagx.jpg',30);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (31, '2021-10-14', 'ivy@ivy.com',
        'b95b134cf21e40b9c2f738c467c513deea3ca67fabe4a9735490a04ef7612483e266a71739ed2931',
        'Ivy & Gold Studio', '413461278', 4);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (31, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (31, 'We are so glad you are here! Fancy creating something magical together? We are a styling, floristry and planning company offering part or full creative for your big day!

We have 14 years of experience creating weddings, events and all things beautiful and decided to start up a new adventure, a business that offers our clients a design-led planning service for weddings and events.
With our years of experience and a small, resourceful team of creatives, we help to transform the smallest ideas into unforgettable memories.',
        'Our business offers a full planning service, styling and floristry or just one element. Some clients book us as their florists, some book styling and props and others only planning services for UK or destination weddings. We are a totally bespoke service so don''t have packages with hidden expenses - simple, clear and tailor made pricing just for you! Your wedding quote should be as unique as your wedding is. Get in touch with us for a quote.',
        5000, 4000, 5000, '+124124466', 'Ivy & Gold Studio', 31, 5,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (31, 'Do you travel'),
       (31, 'Venue Styling, Prop Hire, Other'),
       (31,
        'Furniture, Glassware, Tableware, Signage, Backdrops, Centrepieces, Props, Balloons, Mobile Bar, Light-up Letters, Other');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (75,'Ivy & Gold Studio','flowers-609165_1920_d1dhvb','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928566/flowers-609165_1920_d1dhvb.jpg',31),
    (76,'Ivy & Gold Studio','flowers-260897_1920_c3wkxj','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928563/flowers-260897_1920_c3wkxj.jpg',31),
    (77,'Ivy & Gold Studio','bride-1850126_1920_tkyb5h','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928554/bride-1850126_1920_tkyb5h.jpg',31);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (32, '2021-10-14', 'gillian@gillian.com',
        '348e3390ff9dc74b7b0f2aacf972f82b8c6f555bd10b22f3f8b932b19c63729e7fe19fae7c2e1164',
        'Gillian Million Ltd.', '+3546989980', 19);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (32, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (32, 'Gillian Million designs and creates wedding accessories and bespoke luxuries all created by hand, from delicate hairvines to bejewelled bouquets, as well as offering &ldquo;Pre Loved, Once Worn&rdquo;designer wedding dresses to make another bride extremely happy!

Gillian Million designs and creates wedding accessories and bespoke handmade luxuries for brides all over the world, including celebrity and royal clients.',
        'In addition to the individual care and attention offered by its well-established bespoke service, Gillian Million has its online shop which is regularly updated with new styles and ideas. You can now browse at your leisure and purchase Gillian’s exquisite designs from the comfort of your own home.

Gillian Million also offers clients a beautiful Designer Wedding Dress collection at affordable prices. We take in dresses which are less than 2 years old, all have just been worn for 8 hours, come dry-cleaned and in original packaging. We also have a seamstress to make all the necessary alterations.',
        1000, 500, 5000, '+3252352355', 'Gillian Million', 32, 5,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (32, 'Do you do bespoke bouquet designs');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (78,'Gillian Million','bridal-bouquet-4569173_1920_d9wrlw','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928551/bridal-bouquet-4569173_1920_d9wrlw.jpg',32),
    (79,'Gillian Million','flower-837159_1920_tmnbrt','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928553/flower-837159_1920_tmnbrt.jpg',32),
    (80,'Gillian Million','bride-and-groom-3098858_1920_nww0j1','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928551/bride-and-groom-3098858_1920_nww0j1.jpg',32);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (33, '2021-10-14', 'poppies@poppies.com',
        '62f0f88f8c859025914c1c490740ea0443c0d3d4d62cdb2214a66e8a369b14b5ba711afacc4b80d3',
        'Poppies Ltd.', '+352546457568', 34);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (33, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (33,
        'Our decades of experience bring together a truly inspired portfolio. Having worked in Stately Homes and Castles to Hotels, Private Houses Barns and Marquees, our designers work with you whether you love classic or contemporary, rustic or meadow style.',
        'Our ethos is to listen, interpret your ideas, and to design and bring together the most amazing flowers. We can transform your ideas into reality that will blow you away.

We love to show you how passionate we are about our profession. Call us and begin your journey to your dream.',
        1000, 500, 3000, '+345678878675', 'Poppies', 33, 5,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (33, 'Do you do bespoke bouquet designs'),
       (33, 'Do you also do venue dressing'),
       (33, 'Can you decorate our car'),
       (33, 'Do you do buttonholes'),
       (33, 'Can you decorate the ceremony room');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (81,'Poppies','flower-3185225_1920_n9zw7b','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928553/flower-3185225_1920_n9zw7b.jpg',33),
    (82,'Poppies','flower-393051_1920_ukluts','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928552/flower-393051_1920_ukluts.jpg',33),
    (83,'Poppies','bouquet-1566272_1920_ws7t3q','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928550/bouquet-1566272_1920_ws7t3q.jpg',33);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (34, '2021-10-14', 'luke@luke.com',
        'c1d04fd482fa886ee9001512f80a0a4ad434639de7e2e58922e4efa46092a3877509286ff53f0edb',
        'Luke and Lottie Floral Design Ltd.', '+345237562', 47);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (34, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (34,
        'Luke & Lottie founder Clare Luke has assembled a team of incredible florists that bring their own perspective, depth of style and panache.',
        'Our exceptional team have thrilled literally hundreds of happy couples with our unique designs, creative approach and attention to detail.',
        600, 1000, 5000, '+356237562865', 'Luke and Lottie Floral Design', 34, 5,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (34, 'Do you do bespoke bouquet designs'),
       (34, 'Do you also do venue dressing'),
       (34, 'Can you decorate our car'),
       (34, 'Do you do buttonholes'),
       (34, 'Can you decorate the ceremony room');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (84,'Luke and Lottie Floral Design','bouquet-3676036_1920_rwjby7','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928551/bouquet-3676036_1920_rwjby7.jpg',34),
    (85,'Luke and Lottie Floral Design','bouquet-2041844_1920_yaoie7','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928551/bouquet-2041844_1920_yaoie7.jpg',34),
    (86,'Luke and Lottie Floral Design','bouquet-2563485_1920_wwewqk','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928550/bouquet-2563485_1920_wwewqk.jpg',34);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (35, '2021-10-14', 'moments@moments.com',
        'ee834268d6ae72bf1e2ea83f79d97771a591cf4bcf1f05e2de8ee3ec4c6cd8a0d6871db4f8b535aa',
        'Moments In Time Bridal Outlet Ltd.', '+7656434245678', 62);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (35, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (35,
        'A friendly Wedding shop selling designer wedding dresses all to buy off the rail at outlet prices. We also provide venue decor for all events.',
        'We are a One Stop Wedding & Event Shop open 7 days a week.
We incorporate a Bridal Outlet selling designer Wedding Dresses in all sizes, priced £125 - £799. Appointments are advisable but we do accept walkins if we are not busy.
Our Event Decor and Planning section can provide everything you need for any event. Your wedding is one of the most important days in your life. Let us help you create that unforgettable image that will remain in your memories for evermore. Our friendly, approachable team will welcome you and make you feel comfortable and special during what can be a stressful and tiring time.
We have a photographic studio upstairs and we also work with over 30 other suppliers to ensure you have the day of your dreams. Appointments can be made in the shop to meet any of our suppliers at a time to suit you.',
        1200, 125, 799, '+3462848532', 'Moments In Time Bridal Outlet Ltd.', 35, 5,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (35, 'Do you do bespoke bouquet designs'),
       (35, 'Do you also do venue dressing'),
       (35, 'Can you decorate our car'),
       (35, 'Do you do buttonholes');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (87,'Moments In Time Bridal Outlet','beach-1854072_1920_ktj8ok','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928549/beach-1854072_1920_ktj8ok.jpg',35),
    (88,'Moments In Time Bridal Outlet','bouquet-1851462_1920_p9c93s','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928549/bouquet-1851462_1920_p9c93s.jpg',35),
    (89,'Moments In Time Bridal Outlet','flowers-2073823_1920_xsrflg','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928538/flowers-2073823_1920_xsrflg.jpg',35);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (36, '2021-10-14', 'ambience@ambience.com',
        '8042707fecaac8ef412c67af5bf8f69a2c3b8bf53087e7bbaa7005bad9ba2ef23aecc16e46bf7b77',
        'Ambience Venue Styling Ayrshire Ltd.', '+13463256', 77);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (36, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (36, 'If you&rsquo;re planning a wedding in Ayrshire then make sure you choose Ambience Venue Styling. As the stylist for this vibrant and diverse county, I provide a personal local service helping brides to create the dream setting for their wedding ceremonies and receptions.

Ayrshire is blessed with simply stunning wedding and celebration venues, both rural and the counties cities and towns. With this wealth of diversity in these areas I am continuously inspired by the ever changing seasons and styles that surround the area and compliment these beautiful venues.',
        'Planning a wedding or event can be a daunting prospect, where do you start? As a venue stylist I am here to work with you to help visualise and make a reality the dreams you have for your big event. If you aren’t quite there yet and are simply overwhelmed by the huge amount of styling ideas and their content, I am here to listen, advise, design, create and finalise a venue styled to your dreams. It is important to remember that these memories are made to last a life time, to look back on with delight. With using Ambience Venue Styling Ayrshire, I will work with you to make your special day venue vision a reality.',
        2000, 500, 3000, '+2345675432', 'Ambience Venue Styling Ayrshire', 36, 5,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (36, 'Do you do bespoke bouquet designs'),
       (36, 'Do you also do venue dressing'),
       (36, 'Can you decorate our car'),
       (36, 'Do you do buttonholes'),
       (36, 'Do you do bespoke bouquet designs');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (90,'Ambience Venue Styling Ayrshire','bouquet-168831_1920_nkfjkq','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928549/bouquet-168831_1920_nkfjkq.jpg',36),
    (91,'Ambience Venue Styling Ayrshire','wedding-3222532_1920_ozjzmn','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928539/wedding-3222532_1920_ozjzmn.jpg',36),
    (92,'Ambience Venue Styling Ayrshire','roses-1420719_1920_xligg0','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928538/roses-1420719_1920_xligg0.jpg',36);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (37, '2021-10-14', 'urban@urban.com',
        '5f77be66d9a6b3c86384b77446da416b42b89f2364a30b8ec52c573e9e6b9e897a6fa8ec864fbb2a',
        'Urban Flower Farmer Ltd.', '+2345675432', 92);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (37, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (37,
        'Here at Urban Flower Farmer we love nothing more than working on Weddings & Events, bringing your ideas to life and creating real memories for your special day. We are eco friendly florists using recyclable/sustainable materials creating beautiful flower arrangements for you event using British grown seasonal flowers.',
        'Unique, natural flower design at its best, we have over 14 years experience in floral design creating stunning flowers for your special day.',
        600, 700, 10000, '+342387754', 'Urban Flower Farmer', 37, 5,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (37, 'Do you do bespoke bouquet designs'),
       (37, 'Do you also do venue dressing'),
       (37, 'Can you decorate our car'),
       (37, 'Do you do buttonholes'),
       (37, 'Do you do bespoke bouquet designs');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (93,'Urban Flower Farmer','wedding-3689777_1920_tybufn','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928539/wedding-3689777_1920_tybufn.jpg',37),
    (94,'Urban Flower Farmer','marriage-2150887_1920_muq1ra','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928538/marriage-2150887_1920_muq1ra.jpg',37),
    (95,'Urban Flower Farmer','wedding-2595862_1920_zviw4e','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928539/wedding-2595862_1920_zviw4e.jpg',37);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (38, '2021-10-13', 'flavour@flavour.com',
        '2118fa48691945589090afedb23b0251f20cb05b0e18cfeca16159bca2989fe0b1ea130e9fd6b101',
        'Mr Flavour Weddings', '+34234235465', 107);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (38, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (38,
        'Mr Flavour specialise in creating the perfect blend of innovation and organisation in delivering perfect weddings and events. We work meticulously with industry-leading suppliers and our extensive dream in creating your perfect dream wedding!',
        'We work a little differently compared to most wedding planners, we are also a wedding supplier to many weddings throughout the year. Our wedding services include wedding food & drinks, wedding floristry, wedding stationary, wedding photographer & wedding videographer, all who are part of our inhouse team who work across the country at a range of events with us. The perks of being both is we can guide our couples with background experience on how to:- maximise their budget on each service, what options they have per service and in some situations provide alternative ideas that may suit at weddings. Of course, you are free to use alternative suppliers in any service we offer and we will always provide options for you to choose from based on your requirements.',
        1000, 1000, 9000, '+5456475', 'Mr Flavour Weddings', 38, 5,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (38, 'Do you do bespoke bouquet designs'),
       (38, 'Do you also do venue dressing'),
       (38, 'Can you decorate our car'),
       (38, 'Do you do buttonholes'),
       (38, 'Do you do bespoke bouquet designs');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (96,'Mr Flavour Weddings','wedding-2595862_1920_zviw4e','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928538/wedding-2700495_1920_jdfkga.jpg',38),
    (97,'Mr Flavour Weddings','wedding-2207211_1920_uvowzp','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928538/wedding-2207211_1920_uvowzp.jpg',38),
    (98,'Mr Flavour Weddings','wedding-1854074_1920_zr1mto','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928538/wedding-1854074_1920_zr1mto.jpg',38);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (39, '2021-10-14', 'blend@blend.com',
        '924353445d20fae74745f20be519b23342fd23066c13151d365a47042f3b5c966fd3b5259099c567',
        'Blend & Bloom', '+325626523532', 122);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (39, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (39,
        'We offer a bespoke service, so if you would like flowers on your wedding day that are beautiful and original then we would love to work.',
        'We understand how important flowers are to a wedding and to the bride. Our experienced florist is on hand to offer inspiration and advice.',
        500, 100, 1000, '+24546457', 'Blend & Bloom', 39, 5,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (39, 'Do you do bespoke bouquet designs'),
       (39, 'Do you also do venue dressing'),
       (39, 'Can you decorate our car'),
       (39, 'Do you do buttonholes'),
       (39, 'Do you do bespoke bouquet designs');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (99,'Blend & Bloom','roses-2039184_1920_et7owk','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928537/roses-2039184_1920_et7owk.jpg',39),
    (100,'Blend & Bloom','flowers-1951456_1920_rqmrrn','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928536/flowers-1951456_1920_rqmrrn.jpg',39),
    (101,'Blend & Bloom','wedding-1846114_1920_tgaqax','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928537/wedding-1846114_1920_tgaqax.jpg',39);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (40, '2021-10-14', 'lcn@lcn.com',
        '83b30c1ad6245d05cefe63730322f1065255d9ae18a6a80a507d94be3dc29e9fda796c6ee6a75444',
        'LCN Floral Design', '+32653478634', 137);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (40, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (40,
        ' LCN Floral Design offers a comprehensive floral design service within the wedding industry.From small intimate events to large events we are able to cater for all events ensuring a keen eye for detail and creating your vision and turning into a reality.',
        'LCN Floral Design have over 18 years experience in the Wedding Industry creating a bride''s vision into a reality for many years and we still have our passion today. Working with brides and building friendships and relationships we really strive to create a beautiful creation for their special day.

From bridal bouquets, bridesmaids, buttonholes, centrepieces, church decoration, arches and more we are able to focus on our brides and give them 100% as we only work with ONE BRIDE PER DAY.',
        400, 400, 5000, '+35637563', 'LCN Floral Design', 40, 5,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (40, 'Do you do bespoke bouquet designs'),
       (40, 'Do you also do venue dressing'),
       (40, 'Can you decorate our car'),
       (40, 'Do you do buttonholes'),
       (40, 'Do you do bespoke bouquet designs');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (102,'LCN Floral Design','wedding-flowers-2051724_1920_bpzpjy','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928549/wedding-flowers-2051724_1920_bpzpjy.jpg',40),
    (103,'LCN Floral Design','wedding-3656167_1920_c0dwgo','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928539/wedding-3656167_1920_c0dwgo.jpg',40),
    (104,'LCN Floral Design','bouquet-2041844_1920_yaoie7','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636928551/bouquet-2041844_1920_yaoie7.jpg',40);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (41, '2021-10-14', 'rockabilly@rockabilly.com',
        '9ad46eeda64e086f561fc5448c5672c454cdc0245c381f1f778b8bb976babf1c13817cc580adf451',
        'Rockabilly Bakery Ltd.', '+326582735', 5);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (41, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (41,
        'We offer a unique service where the customers’ desires always come first. All cakes are made to the customers’ preference; any cake whether contemporary and stylish, or classic and elegant, we’re sure to create a delicious work of art that will make your event even more memorable.',
        'For an additional charge, wider locations will be accepted. We provide a delivery and set up service at your venue by prior arrangement, and we are also able to hire out a range of elegant cake stands.

- Iced wedding cakes for up to 95 guests start from £250
- 3 tier ‘naked’ or ‘buttercream’ cakes start from £225
- Fancie Favours such as cake pops, macarons & iced biscuits start from £1.50 each and can be personalised
- Dessert Tables – bespoke price on request',
        600, 200, 1000, '+325632765274', 'Rockabilly Bakery', 41, 8,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (41, 'Do you do bespoke bouquet designs'),
       (41, 'Do you also do venue dressing'),
       (41, 'Can you decorate our car'),
       (41, 'Do you do buttonholes'),
       (41, 'Do you do bespoke bouquet designs');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (105,'Rockabilly Bakery','wedding-cake-1704427_1920_wzyzgr','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930601/wedding-cake-1704427_1920_wzyzgr.jpg',41),
    (106,'Rockabilly Bakery','wedding-reception-2054002_1920_zk97et','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930602/wedding-reception-2054002_1920_zk97et.jpg',41),
    (107,'Rockabilly Bakery','affair-1238440_1920_zklzdh','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930603/affair-1238440_1920_zklzdh.jpg',41);
-- CAKES
INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (42, '2021-10-14', 'weedingcakes@weedingcakes.com',
        '1585d2d493f0dd60b1674945516c122e0f04224cca216a721f09c88f1336fb732595aa9d18657ddb',
        'The Wedding Cake Co.', '+37562847624', 20);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (42, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (42,
        'Welcome to The Wedding Cake Co... offering uniquely designed cakes to help capture the essence of your special day, your wedding cake will be crafted using only the purest ingredients, specifically blended to your exacting requirements and taste.',
        'Creating a stunning centerpiece for your day isn''t purely by chance. It''s achieved through years of experience and dedication.

The Wedding Cake Co offers brides and grooms across Lancashire, Cheshire, Yorkshire and the Lake District wedding cakes that exceed their wildest expectations. Whatever your colour scheme or wedding theme, Cath will combine her expertise in sugar craft and her degree in design to create a masterpiece worthy of the biggest day of your life.

All our cakes are lovingly hand baked and decorated using only the very best ingredients; 100% organic flours, locally sourced free range eggs, unrefined sugars, unsalted butter and hand made jams. We do not add any preservatives or nasties.',
        500, 200, 700, '+3653463', 'The Wedding Cake', 42, 8,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (42, 'Do you do bespoke designs'),
       (42, 'Do you deliver'),
       (42, 'Can you supply cake toppers');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (108,'The Wedding Cake','wedding-cake-6018507_1920_goquqp','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930602/wedding-cake-6018507_1920_goquqp.jpg',42),
    (109,'The Wedding Cake','wedding-cake-639181_1920_njv8yc','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930602/wedding-cake-639181_1920_njv8yc.jpg',42),
    (110,'The Wedding Cake','cake-2082939_1920_rriagp','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930603/cake-2082939_1920_rriagp.jpg',42);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (43, '2021-10-14', 'Centrepiece@Centrepiece.com',
        '31e8741baaa71a3d40976cf0ff123572601804ac2c9498824922f52b32db0c935d45f7ab4247fbfe',
        'Centrepiece Cakes Ltd.', '4763463476', 35);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (43, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (43,
        'Centrepiece Cakes is one of the most sought-after cake designers. We create stunning couture wedding cakes, birthday &amp; celebration cakes, dessert tables, cake pops, cupcakes, cookies and more. Whatever the occasion we can design and create all the edible sweet treats you want!',
        'No wedding or celebration is complete without that special Centrepiece to mark the wonderful occasion. I make my cakes with love and passion to ensure you get your perfect cake, which not only looks amazing but tastes fantastic too. I will help you design, plan and choose the right cake for your occasion, taste and budget. Traditional, modern, contemporary, romantic, vintage, unusual or stylish - your cake will be just as you imagined!

To finish your perfect cake, I hand-make fine sugar decorations including flowers, lace & beautiful piping work and will custom make moulds and embellishments from items that you are using for your wedding and are personal to you, such as broaches, jewellery and lace.

Fresh cut flowers, silk flowers or ornaments can also be used.',
        450, 400, 900, '+26246346', 'Centrepiece Cakes', 43, 8,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (43, 'Can you do gluten/wheat/dairy free'),
       (43, 'Can you supply cake toppers'),
       (43, 'Do you do bespoke designs'),
       (43, 'Do you deliver');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (111,'Centrepiece Cakes','wedding-cake-407170_1920_xttxjn','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930603/wedding-cake-407170_1920_xttxjn.jpg',43),
    (112,'Centrepiece Cakes','wedding-cake-639516_1920_uear8w','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930603/wedding-cake-639516_1920_uear8w.jpg',43),
    (113,'Centrepiece Cakes','wedding-cake-478315_1920_mnjbql','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930603/wedding-cake-478315_1920_mnjbql.jpg',43);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (44, '2021-10-14', 'bunty@bunty.com',
        'df127ac61e31686b997aebe4df173953659cc1f90cfc48f690abb881d669be20ff492986955c23c4',
        'Bunty''s Wedding Cakes Ltd.', '+463475896967', 48);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (44, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (44,
        'At Award winning Bunty''s Wedding Cakes, we know that the perfect wedding cake is an integral part of your perfect day. We work with you to develop your dream wedding cake with our full complimentary consultation service.',
        'With years of experience in making wedding cakes, you are able to trust that your ideas will become a reality for your wedding cake and no idea is too big or too small. We offer expertise in lace work, sugar flowers, sculpture and hand painted cakes to name but a few.

We take pride in offering a premier service to all of our Clients and can discuss your dream wedding cake ideas at a face to face consultation, provide you with detailed sketches of your wedding cake and offer a wedding cake tasting service.

Contact us today to discuss your wedding cake ideas or to book a consultation with us.',
        300, 50, 500, '+2453657865432', 'Bunty''s Wedding Cakes', 44, 8,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (44, 'Do you do bespoke designs'),
       (44, 'Do you deliver');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (114,'Bunty''s Wedding Cakes','cake-1814225_1920_n1wcna','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930604/cake-1814225_1920_n1wcna.jpg',44),
    (115,'Bunty''s Wedding Cakes','cake-balls-4139982_1920_pzc1pb','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930613/cake-balls-4139982_1920_pzc1pb.jpg',44);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (45, '2021-10-14', 'andreas@andrea.com',
        '193c47174fc0b20d4d52c5026b6777686083860ea189729ea9c77e08b00f409e7cfb388fbe3353ec',
        'Andrea''s Wedding Cakes', '+2465237593', 63);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (45, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (45, 'My aim is to create a wedding cake which reflects your personal style or wedding theme
Having had many years experience in making wedding cakes, my aim is to create a stunning centrepiece for your wedding day at an affordable price. Your cake can be tailored to suit your wedding theme with handcrafted realistic sugar flowers. My cakes have been featured in the ''Wedding Cake'' design source magazines and also in ''An Essex Wedding'' magazine.',
        'Evening or weekend appointments are available for a free consultation and tasting, based near Chelmsford and Maldon. Cake tasting by appointment only.

Each cake is baked and decorated two days before delivery to ensure they are at their freshest and using the best ingredients (including organic where possible). Having had many years experience in making wedding cakes your cake will be designed to suit your wedding theme and will not only look amazing but will taste special as well.

I also have many cake stands available to hire.',
        450, 100, 1000, '+26582375236', 'Andrea''s Wedding Cakes', 45, 8,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (45, 'Do you do bespoke designs'),
       (45, 'Do you deliver'),
       (45, 'Can you supply cake toppers');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (116,'Andrea''s Wedding Cakes','cake-3864141_1920_c4zjsq','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930612/cake-3864141_1920_c4zjsq.jpg',45),
    (117,'Andrea''s Wedding Cakes','cake-balls-4073496_1920_gz4xnn','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930613/cake-balls-4073496_1920_gz4xnn.jpg',45),
    (118,'Andrea''s Wedding Cakes','wedding-2888414_1920_jxhyh3','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930621/wedding-2888414_1920_jxhyh3.jpg',45);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (46, '2021-10-14', 'pinkfrosting@pink.com',
        '565003dd894ced05f4e8be7bb66edc85ec6c0c485b063430d5fb3bf3509425b5dc39d48ee74eb1ee',
        'Pink Frosting Cake Company', '+12345678976543', 78);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (46, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (46,
        'Our unique wedding cakes are created with care and attention, right from the initial consultation. Trained by some of the most renowned professionals in the industry, you can be sure that we will make your wedding cake will not only look fantastic, but it will taste amazing too!',
        'Our wedding cakes are mixed and baked by us using the finest recipes that we have tried and tested time and again, using layers of moist sponge filled as requested and a swiss meringue or a classic buttercream, with fruit preserves or ganache.

Although we are deliver predominantly to North West wedding venues, we are also happy to deliver your wedding cake to all areas of the UK including London.

Kelly works closely with her clients to ensure that the end cake is of a design and taste that is unrivaled in the North West of England. If you have any specific needs or requests for your wedding cake, please get in touch so that we can advise the options.',
        300, 150, 1000, '+2423534468', 'Pink Frosting Cake Company', 46, 8,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (46, 'Do you do bespoke designs'),
       (46, 'Do you deliver'),
       (46, 'Can you do gluten/wheat/dairy free');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (119,'Pink Frosting Cake Company','valentine-3925930_1920_j8rlgj','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930613/valentine-3925930_1920_j8rlgj.jpg',46),
    (120,'Pink Frosting Cake Company','cake-16887_1920_ydaliu','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930604/cake-16887_1920_ydaliu.jpg',46),
    (121,'Pink Frosting Cake Company','cake-balls-4139989_1920_fyigka','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930616/cake-balls-4139989_1920_fyigka.jpg',46);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (47, '2021-10-14', 'cakesfromtheheart@gmail.com',
        'b62a37602882c34bb375e811bdbeae53caf364bd4f311aa8c7b9d602f4e9738fb03dbf3dd76e1ef0',
        'Cakes From The Heart Ltd.', '+3563875629385', 93);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (47, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (47,
        'Cakes From The Heart offer bespoke and unique wedding cakes. We pride ourselves in our &quot;no two cakes are the same&quot; policy. Your wedding is unique to you and your cake will be the same.',
        'We cater for all tastes and do egg-less, gluten free and dairy free cakes. All our cakes taste as good as they look. Our style is your style so we create your unique cake, be it a cupcake tower, a cake with personalised toppers, handcrafted flowers to match your wedding flowers or something a little more unique.

We also love doing the classics and vintage styles, and are now offering the chance to have picture images or icing characters on your cakes!

We are based in Higham Ferrers with our showroom in Rushden but serve the whole of Northants and Beds and include set up and delivery in our service.

Enquire now to arrange a consultation with designer Louise at our showroom and discuss all your cake needs from flavours to style and theme!

Wedding cakes generally get booked well in advance so book your consultation in as soon as you have secured your venue.',
        350, 220, 700, '+5472874529385', 'Cakes From The Heart', 47, 8,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (47, 'Can you do gluten/wheat/dairy free'),
       (47, 'Can you supply cake toppers'),
       (47, 'Do you do bespoke designs'),
       (47, 'Do you deliver');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (122,'Cakes From The Heart','cream-3098862_1920_jexnrp','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930616/cream-3098862_1920_jexnrp.jpg',47),
    (123,'Cakes From The Heart','wedding-1236013_1920_gw5fhw','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930616/wedding-1236013_1920_gw5fhw.jpg',47);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (48, '2021-10-14', 'sugar@sugar.com',
        'e648769bc3a804dbbf0ee661cf297eb1c889d65fe84fa16415d9936efacd3836d05a99d2e1766464',
        'The Sugar & Spice Cake Company Ltd.', '+1423546666', 108);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (48, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (48, 'Here at the Sugar & Spice Cake Company, I pride myself on making the most gorgeous, bespoke wedding cakes.

I offer a professional & high quality, but also friendly & approachable service. Each cake is individually designed & handcrafted just for you to incorporate your personality, wedding colours, theme & even your dress.',
        'My wedding cakes are available in a variety of flavours and sizes. I have also trained in Floristry so can skillfully add fresh flowers to any cake design,and will happily work with your florist to coordinate set up times on the morning of your wedding.

If you are looking for something a little different or less formal, Buttercream Cakes are a great, comtemporary alternative to traditional icing covered cakes.

These are just some examples, however I offer a bespoke service, making cakes unique to you. Maybe you already have your cake in mind, but if not, please contact me and we can come up with you design together.',
        800, 50, 950, '+23456786543', 'The Sugar & Spice Cake Company', 48, 8,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (48, 'Do you deliver'),
       (48, 'Do you do bespoke designs'),
       (48, 'Can you supply cake toppers');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (124,'The Sugar & Spice Cake Company','valentines-day-3934779_1920_usvazx','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930615/valentines-day-3934779_1920_usvazx.jpg',48),
    (125,'The Sugar & Spice Cake Company','cake-balls-4073496_1920_gz4xnn','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930613/cake-balls-4073496_1920_gz4xnn.jpg',48);
INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (49, '2021-10-14', 'divine@divine.com',
        '61e78c104f2c4d887386c8b0f0f282984ce4f9054ad28f5ae4cfa4d399d8b16f5a12b0146065a952',
        'Divine Wedding Cakes Ltd.', '+2345567897', 123);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (49, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (49,
        'Stunning, bespoke wedding cakes designed by award winning Jon Rendle, a fully qualified cake maker with over 30 years experience. Recommended by many of Devon and Cornwall''s most prestigious venues.',
        'At Divine Wedding Cakes we provide a personal and professional service, from placing your order to delivery and set-up.

Select a design from our website, or let us create a unique cake that reflects your personality or wedding theme. Our designs range from traditional Royal iced fruit cakes to contemporary cakes - including individual mini cakes and cupcakes, novelty cakes, chocolate cakes - all with a choice of exciting cake fillings and exquisite flavours!',
        450, 99, 599, '+23456789765432', 'Divine Wedding Cakes', 49, 8,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (49, 'Do you do bespoke designs'),
       (49, 'Do you deliver'),
       (49, 'Can you supply cake toppers');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (126,'Divine Wedding Cakes','cream-3098862_1920_jexnrp','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930616/cream-3098862_1920_jexnrp.jpg',49),
    (127,'Divine Wedding Cakes','valentine-3925931_1920_xwpgup','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930614/valentine-3925931_1920_xwpgup.jpg',49);

INSERT INTO suppliers (id, created, email, password, company_name, phone_number, address_id)
VALUES (50, '2021-10-14', 'belsize@belsize.com',
        '362ac18b178b8e19c0ad4e0583a386d07be8821bfb2a1072b74dedc54bffad589bcfa19773dd3ced',
        'Belsize Cakes Ltd.', '+2134567899', 138);
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (50, 3);
INSERT INTO offers (id, about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id,
                    category_id,status)
VALUES (50, 'Organic designer cakes with a contemporary twist, specialising in texture, aged stone and marble, hand-painted art with intricate designs. We are committed to using organic ingredients and low sugar.

We are versatile in design styles, flavour pairings and we offer a range of dessert table options including cake popsicles, doughnut walls, and cupcakes.',
        'Our individual tasting sessions where you taste up to five cake flavours, discuss designs and where we create initial sketches are held in our Central London venue or a location of your choice. We absolutely enjoy the the designing process and welcome all input by the bride and groom and always aim to create something truly special. Alternatively, we can post our cake sample box and discuss over the phone.

We encourage booking a year ahead of your wedding but if we have availability, we can take urgent orders with minimum 2 weeks'' notice. ​

We are based in Central London but deliver to surrounding counties.

To inquire or book a consultation with us, please send us a message and we''ll get back to you in 24 hours.',
        200, 300, 1800, '+35827593786246346', 'Belsize Cakes', 50, 8,'APPROVED');
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES (50, 'Do you do bespoke designs'),
       (50, 'Do you deliver'),
       (50, 'Can you supply cake toppers');
INSERT INTO pictures (id,name,public_id,url,offer_id)
VALUES
    (128,'Belsize Cakes','food-3284093_1920_vkmpvr','https://res.cloudinary.com/dj5akxhq1/image/upload/v1636930613/food-3284093_1920_vkmpvr.jpg',50);
/* INSERT INTO suppliers (id,created,email,password,company_name,phone_number,address_id,category_id,status)
VALUES ();
INSERT INTO suppliers_roles(supplier_id, roles_id)
VALUES (1,3);
INSERT INTO offers (id,about, description, km_coverage, min_price, max_price, phone_number, title, supplier_id)
VALUES();
INSERT INTO offer_included_attributes(offer_id, included_attributes)
VALUES();
 */
-- INSERT USER 1
INSERT INTO budgets (id, initial_budget,current_budget)
VALUES (2, 10000,10000);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (32, "Ceremony Venue Fee", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (33, "Reception Venue", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (34, "Rehearsal Dinner Venue", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (35, "Food and Service", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (36, "Beverage and Bartenders", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (37, "Photographer", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (38, "Additional Prints", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (39, "Ceremony Decorations", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (40, "Bouquet", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (41, "Wedding Party Bouquets", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (42, "Wedding Party Boutonnieres", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (43, "Flower Girl Flowers", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (44, "Cake and Cutting Fee", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (45, "Dress and Alterations", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (46, "Groom''s and Groomsmen''s Attire", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (47, "Headpiece and Veil", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (48, "Wedding Accessories", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (49, "Tux or Suit", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (50, "Additional Accessories", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (51, "Band", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (52, "DJ", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (53, "Ceremony Musicians", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (54, "Invitations and Reply Cards", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (55, "Favors and Gifts", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (56, "Officiant", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (57, "Limo or Car Rentals", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (58, "Guest Shuttle or Parking", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (59, "Hair and Makeup", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (60, "Prewedding Pampering", 0, 0, false, 2);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (61, "Wedding rings", 0, 0, false, 2);

INSERT INTO weddings (id, budget_id)
VALUES (2, 2);

INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (65, "Announce your engagement", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (66, "Plan your engagement party", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (67, "Set a wedding budget", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (68, "Start creating your guest list", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (69, "Find and book your venue", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (70, "Decide on your color scheme", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (71, "Select your wedding party", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (72, "Hire your photographer", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (73, "Schedule an engagement photo shoot", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (74, "Create your wedding website ", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (75, "Hire your caterer", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (76, "Create and send save-the-dates", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (77, "Select an officiant", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (78, "Reserve accommodations for guests", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (79, "Book your wedding night accommodations", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (80, "Find and order your wedding look", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (81, "Book your band", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (82, "Find and hire your DJ", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (83, "Start thinking about your playlist", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (84, "Schedule your fitting appointments", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (85, "Finalize your guest list", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (86, "Hire your florist", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (87, "Update your vendor team", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (88, "Order outfits for your wedding party", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (89, "Hire your baker", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (90, "Hire your ceremony musician", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (91, "Order your wedding invitations", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (92, "Start planning your rehearsal dinner", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (93, "Find and order your event rentals", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (94, "Start planning your honeymoon", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (95, "Research wedding insurance", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (96, "Hire your hair and makeup stylist", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (97, "Add more gifts to your registry", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (98, "Schedule your ceremony rehearsal", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (99, "Order your partner''s attire", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (100, "Order outfits for your ring bearer and flower girl", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (101, "Purchase your wedding accessories", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (102, "Find accessories for your wedding party", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (103, "Purchase your wedding rings", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (104, "Book your wedding transportation", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (105, "Order your wedding favors", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (106, "Get your guest book", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (107, "Send your wedding invitations ", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (108, "Send your rehearsal dinner invites", false, false, 2),
       (109, "Plan your wedding ceremony", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (110, "Time to order alcohol ", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (111, "Order day-of stationery", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (112, "Write your vows", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (113, "Purchase gifts for your wedding party", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (114, "Create wedding day timeline", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (115, "Finalize your vendor team", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (116, "Create your seating chart", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (117, "Assign duties to the wedding party", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (118, "Confirm final details with your vendors", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (119, "Pick up your wedding dress, suit, or tux", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (120, "Write a sweet note to your partner", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (121, "Confirm all final payments", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (122, "Pick up your partner''s attire", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (123, "Pack for your honeymoon", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (124, "Prepare toasts", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (125, "Pull together last-minute essentials", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (126, "Bring decor to your reception venue", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (127, "Review your vendors", false, false, 2);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (128, "Send thank-you notes", false, false, 2);

INSERT INTO users (id,created, email, password, first_name, last_name, wedding_id)
VALUES (2,'2021-11-2', 'samantha@gmail.com',
        '35153ca0c770699421f5986b6acb62399525eaad681bce59e03f0ea41a5c42b506db831ceb2dfdf5',
        'Samantha', 'Jackson', 2);
INSERT INTO users_roles (user_id, roles_id)
VALUES (2, 2);

INSERT INTO guests (id, age, attend, email, first_name, last_name, need_hotel, phone_number, type, wedding_to_attend_id)
VALUES (1, 'ADULT', 'PENDING', 'peter@hmc.com', 'Peter', 'Peterson', false, '+3456789', 'FAMILY', 2),
       (2, 'ADULT', 'PENDING', 'maria@hmc.com', 'Maria', 'Peterson', false, '+3456568', 'FAMILY', 2),
       (3, 'CHILD', 'PENDING', null, 'John', 'Peterson', false, null, 'FAMILY', 2),
       (4, 'BABY', 'PENDING', null, 'Aria', 'Peterson', false, null, 'FAMILY', 2),
       (6, 'ADULT', 'ATTENDING', 'charley@hmc.com', 'Charley', 'Johnson', true, '+3456789', 'FRIEND', 2),
       (7, 'ADULT', 'ATTENDING', 'samantha@hmc.com', 'Samantha', 'Manson', true, '+3456789', 'FRIEND', 2),
       (8, 'ADULT', 'DECLINED', 'george@hmc.com', 'George', 'Michelson', true, '+3456789', 'COWORKER', 2),
       (9, 'ADULT', 'ATTENDING', 'jake@hmc.com', 'Jake', 'Milson', false, '+34556689', 'FAMILY', 2),
       (10, 'ADULT', 'ATTENDING', 'melissa@hmc.com', 'Melissa', 'Harper', true, '+3454449', 'FAMILY', 2),
       (11, 'ADULT', 'ATTENDING', 'patrisha@hmc.com', 'Patrisha', 'Michaelson', false, '+3456555', 'COWORKER', 2);
INSERT INTO weddings_favourite_offers
VALUES (2, 2),
       (2, 5),
       (2, 20),
       (2, 30),
       (2, 8),
       (2, 9),
       (2, 18);


-- INSERT ADMIN
INSERT INTO budgets (id, initial_budget,current_budget)
VALUES (1, 15000,15000);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (62, "Ceremony Venue Fee", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (63, "Reception Venue", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (64, "Rehearsal Dinner Venue", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (65, "Food and Service", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (66, "Beverage and Bartenders", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (67, "Photographer", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (68, "Additional Prints", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (69, "Ceremony Decorations", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (70, "Bouquet", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (71, "Wedding Party Bouquets", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (72, "Wedding Party Boutonnieres", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (73, "Flower Girl Flowers", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (74, "Cake and Cutting Fee", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (75, "Dress and Alterations", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (76, "Groom''s and Groomsmen''s Attire", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (77, "Headpiece and Veil", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (78, "Wedding Accessories", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (79, "Tux or Suit", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (80, "Additional Accessories", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (81, "Band", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (82, "DJ", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (83, "Ceremony Musicians", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (84, "Invitations and Reply Cards", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (85, "Favors and Gifts", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (86, "Officiant", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (87, "Limo or Car Rentals", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (88, "Guest Shuttle or Parking", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (89, "Hair and Makeup", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (90, "Prewedding Pampering", 0, 0, false, 1);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (91, "Wedding rings", 0, 0, false, 1);

INSERT INTO weddings (id, date, budget_id)
VALUES (1, '2021-12-12', 1);

INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (129, "Announce your engagement", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (130, "Plan your engagement party", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (131, "Set a wedding budget", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (132, "Start creating your guest list", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (133, "Find and book your venue", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (134, "Decide on your color scheme", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (135, "Select your wedding party", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (136, "Hire your photographer", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (137, "Schedule an engagement photo shoot", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (138, "Create your wedding website ", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (139, "Hire your caterer", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (140, "Create and send save-the-dates", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (141, "Select an officiant", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (142, "Reserve accommodations for guests", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (143, "Book your wedding night accommodations", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (144, "Find and order your wedding look", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (145, "Book your band", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (146, "Find and hire your DJ", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (147, "Start thinking about your playlist", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (148, "Schedule your fitting appointments", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (149, "Finalize your guest list", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (150, "Hire your florist", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (151, "Update your vendor team", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (152, "Order outfits for your wedding party", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (153, "Hire your baker", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (154, "Hire your ceremony musician", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (155, "Order your wedding invitations", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (156, "Start planning your rehearsal dinner", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (157, "Find and order your event rentals", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (158, "Start planning your honeymoon", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (159, "Research wedding insurance", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (160, "Hire your hair and makeup stylist", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (161, "Add more gifts to your registry", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (162, "Schedule your ceremony rehearsal", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (163, "Order your partner''s attire", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (164, "Order outfits for your ring bearer and flower girl", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (165, "Purchase your wedding accessories", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (166, "Find accessories for your wedding party", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (167, "Purchase your wedding rings", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (168, "Book your wedding transportation", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (169, "Order your wedding favors", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (170, "Get your guest book", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (171, "Send your wedding invitations ", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (172, "Send your rehearsal dinner invites", false, false, 1),
       (173, "Plan your wedding ceremony", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (174, "Time to order alcohol ", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (175, "Order day-of stationery", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (176, "Write your vows", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (177, "Purchase gifts for your wedding party", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (178, "Create wedding day timeline", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (179, "Finalize your vendor team", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (180, "Create your seating chart", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (181, "Assign duties to the wedding party", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (182, "Confirm final details with your vendors", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (183, "Pick up your wedding dress, suit, or tux", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (184, "Write a sweet note to your partner", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (185, "Confirm all final payments", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (186, "Pick up your partner''s attire", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (187, "Pack for your honeymoon", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (188, "Prepare toasts", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (189, "Pull together last-minute essentials", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (190, "Bring decor to your reception venue", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (191, "Review your vendors", false, false, 1);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (192, "Send thank-you notes", false, false, 1);

INSERT INTO users (id,created,email,password,first_name,last_name,wedding_id)
VALUES (1,'2021-09-09','john@gmail.com','35153ca0c770699421f5986b6acb62399525eaad681bce59e03f0ea41a5c42b506db831ceb2dfdf5','John','Jackson',1);
INSERT INTO users_roles (user_id,roles_id)
VALUES (1,1),
       (1,2);

INSERT INTO messages(id,body,date,open,is_reply_from_supplier,supplier_id,user_id)
VALUES
    (1,'Hi Ashley! Will you be available at 08.04.2022 for my wedding day? Do you offer video shooting too? Regards, Samantha!',
     '2021-11-18',true,false,1,2),
    (2,'Hi Samantha! Yes, I`m available at 08.04.2022 and I can do videos for your wedding. Regards, Ashley!',
     '2021-11-19',true,true,1,2);
INSERT INTO messages(id,body,date,open,is_reply_from_supplier,supplier_id,user_id)
VALUES
    (4,'Hi Ashley! Can you add more photo to your offer, please?!',
     '2021-11-18',true,false,1,1);

-- INSERT USER 3
INSERT INTO budgets (id, initial_budget,current_budget)
VALUES (3, 15000,15000);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (92, "Ceremony Venue Fee", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (93, "Reception Venue", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (94, "Rehearsal Dinner Venue", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (95, "Food and Service", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (96, "Beverage and Bartenders", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (97, "Photographer", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (98, "Additional Prints", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (99, "Ceremony Decorations", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (100, "Bouquet", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (101, "Wedding Party Bouquets", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (102, "Wedding Party Boutonnieres", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (103, "Flower Girl Flowers", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (104, "Cake and Cutting Fee", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (105, "Dress and Alterations", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (106, "Groom''s and Groomsmen''s Attire", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (107, "Headpiece and Veil", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (108, "Wedding Accessories", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (109, "Tux or Suit", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (110, "Additional Accessories", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (111, "Band", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (112, "DJ", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (113, "Ceremony Musicians", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (114, "Invitations and Reply Cards", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (115, "Favors and Gifts", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (116, "Officiant", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (117, "Limo or Car Rentals", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (118, "Guest Shuttle or Parking", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (119, "Hair and Makeup", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (120, "Prewedding Pampering", 0, 0, false, 3);
INSERT INTO expenses (id, name, price, paid, initial, budget_id)
VALUES (121, "Wedding rings", 0, 0, false, 3);

INSERT INTO weddings (id, budget_id)
VALUES (3, 3);

INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (193, "Announce your engagement", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (194, "Plan your engagement party", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (195, "Set a wedding budget", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (196, "Start creating your guest list", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (197, "Find and book your venue", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (198, "Decide on your color scheme", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (199, "Select your wedding party", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (200, "Hire your photographer", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (201, "Schedule an engagement photo shoot", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (202, "Create your wedding website ", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (203, "Hire your caterer", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (204, "Create and send save-the-dates", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (205, "Select an officiant", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (206, "Reserve accommodations for guests", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (207, "Book your wedding night accommodations", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (208, "Find and order your wedding look", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (209, "Book your band", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (210, "Find and hire your DJ", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (211, "Start thinking about your playlist", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (212, "Schedule your fitting appointments", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (213, "Finalize your guest list", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (214, "Hire your florist", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (215, "Update your vendor team", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (216, "Order outfits for your wedding party", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (217, "Hire your baker", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (218, "Hire your ceremony musician", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (219, "Order your wedding invitations", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (220, "Start planning your rehearsal dinner", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (221, "Find and order your event rentals", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (222, "Start planning your honeymoon", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (223, "Research wedding insurance", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (224, "Hire your hair and makeup stylist", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (225, "Add more gifts to your registry", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (226, "Schedule your ceremony rehearsal", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (227, "Order your partner''s attire", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (228, "Order outfits for your ring bearer and flower girl", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (229, "Purchase your wedding accessories", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (230, "Find accessories for your wedding party", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (231, "Purchase your wedding rings", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (232, "Book your wedding transportation", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (233, "Order your wedding favors", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (234, "Get your guest book", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (235, "Send your wedding invitations ", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (236, "Send your rehearsal dinner invites", false, false, 3),
       (237, "Plan your wedding ceremony", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (238, "Time to order alcohol ", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (239, "Order day-of stationery", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (240, "Write your vows", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (241, "Purchase gifts for your wedding party", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (242, "Create wedding day timeline", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (243, "Finalize your vendor team", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (244, "Create your seating chart", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (245, "Assign duties to the wedding party", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (246, "Confirm final details with your vendors", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (247, "Pick up your wedding dress, suit, or tux", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (248, "Write a sweet note to your partner", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (249, "Confirm all final payments", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (250, "Pick up your partner''s attire", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (251, "Pack for your honeymoon", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (252, "Prepare toasts", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (253, "Pull together last-minute essentials", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (254, "Bring decor to your reception venue", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (255, "Review your vendors", false, false, 3);
INSERT INTO tasks (id, description, completed, initial, wedding_id)
VALUES (256, "Send thank-you notes", false, false, 3);

INSERT INTO users (id,created, email, password, first_name, last_name, wedding_id)
VALUES (3,'2021-11-2', 'jessica@gmail.com',
        '35153ca0c770699421f5986b6acb62399525eaad681bce59e03f0ea41a5c42b506db831ceb2dfdf5',
        'Jessica', 'Parker', 3);
INSERT INTO users_roles (user_id, roles_id)
VALUES (3, 2);
INSERT INTO guests (id, age, attend, email, first_name, last_name, need_hotel, phone_number, type, wedding_to_attend_id)
VALUES
       (12, 'ADULT', 'PENDING', 'maria@hmc.com', 'Maria', 'Peterson', false, '+3456568', 'FAMILY', 3),
       (13, 'CHILD', 'PENDING', null, 'John', 'Peterson', false, null, 'FAMILY', 3),
       (14, 'BABY', 'PENDING', null, 'Aria', 'Peterson', false, null, 'FAMILY', 3),
       (16, 'ADULT', 'ATTENDING', 'charley@hmc.com', 'Charley', 'Johnson', true, '+3456789', 'FRIEND', 3),
       (17, 'ADULT', 'ATTENDING', 'samantha@hmc.com', 'Samantha', 'Manson', true, '+3456789', 'FRIEND', 3),
       (18, 'ADULT', 'DECLINED', 'george@hmc.com', 'George', 'Michelson', true, '+3456789', 'COWORKER', 3),
       (19, 'ADULT', 'ATTENDING', 'jake@hmc.com', 'Jake', 'Milson', false, '+34556689', 'FAMILY', 3),
       (20, 'ADULT', 'ATTENDING', 'melissa@hmc.com', 'Melissa', 'Harper', true, '+3454449', 'FAMILY', 3),
       (21, 'ADULT', 'ATTENDING', 'patrisha@hmc.com', 'Patrisha', 'Michaelson', false, '+3456555', 'COWORKER', 3);
INSERT INTO weddings_favourite_offers
VALUES (3, 3),
       (3, 6),
       (3, 7),
       (3, 31),
       (3, 9),
       (3, 29),
       (3, 48);


INSERT INTO statistics
VALUES (1,0,0,0,0,0,0,0,0,0,0,0,0);

