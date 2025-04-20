create table brand
(
    id serial primary key,
    name varchar(20),
    slug varchar(50),
    description varchar(50),
    logo_url varchar(250),
    website varchar(250)
);

create table seller
(
    id serial primary key,
    name varchar(20),
    description varchar(50),
    logo_url varchar(250),
    rating float not null,
    contact_email varchar(50),
    contact_phone varchar(20),
    created_at timestamp not null
);

create table product
(
    id serial primary key,
    name varchar(50),
    slug varchar(50),
    short_description varchar(50),
    full_description varchar(250),
    seller_id integer references seller (id),
    brand_id integer references brand (id),
    status varchar(10),
    created_at timestamp not null,
    updated_at timestamp
);

create table product_detail
(
    id serial primary key,
    product_id integer not null references product (id),
    weight float,
    dimensions json,
    materials varchar(50),
    country_of_origin varchar(50),
    warranty_info varchar(50),
    care_instructions varchar(50),
    additional_info jsonb
);

create table product_price
(
    id serial primary key,
    product_id integer not null references product (id),
    base_price integer not null,
    sale_price integer,
    cost_price integer,
    currency varchar(3) default 'KRW' not null,
    tax_rate integer not null
);

create table category
(
    id serial primary key,
    name varchar(20) not null,
    slug varchar(50),
    description varchar(50),
    parent_id integer references category (id),
    level integer not null,
    image_url varchar(250)
);

create table product_category
(
    id serial primary key,
    product_id integer not null references product (id),
    category_id integer not null references category (id),
    is_primary boolean not null
);

create table product_option_group
(
    id serial primary key,
    product_id integer not null references product (id),
    name varchar(20),
    display_order integer not null
);

create table product_option
(
    id serial primary key,
    option_group_id integer not null references product_option_group (id),
    name varchar(20),
    additional_price integer,
    sku varchar(20) not null,
    stock integer not null,
    display_order integer not null
);

create table product_image
(
    id serial primary key,
    product_id integer not null references product (id),
    url varchar(250),
    alt_text varchar(20),
    is_primary boolean not null,
    display_order integer not null,
    option_id integer references product_option (id)
);

create table tag
(
    id serial primary key,
    name varchar(20),
    slug varchar(50)
);

create table product_tag
(
    id serial primary key,
    product_id integer not null references product (id),
    tag_id integer not null references tag (id)
);

create table review
(
    id serial primary key,
    product_id integer not null references product (id),
    user_id varchar(30) not null,
    rating float not null,
    title varchar(50),
    content varchar(1000),
    created_at timestamp not null,
    updated_at timestamp,
    verified_purchase boolean not null,
    helpful_votes integer not null
);

